/*
 * Copyright (c) 2023 Elide Ventures, LLC.
 *
 * Licensed under the MIT license (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   https://opensource.org/license/mit/
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License.
 */

package elide.runtime.gvm.internals.context

import com.lmax.disruptor.EventFactory
import com.lmax.disruptor.EventHandler
import com.lmax.disruptor.LifecycleAware
import com.lmax.disruptor.SleepingWaitStrategy
import com.lmax.disruptor.dsl.Disruptor
import com.lmax.disruptor.dsl.ProducerType
import org.graalvm.nativeimage.ImageInfo
import org.graalvm.nativeimage.LogHandler
import org.graalvm.nativeimage.Platform
import org.graalvm.nativeimage.c.type.CCharPointer
import org.graalvm.polyglot.Context.Builder
import org.graalvm.polyglot.Engine
import org.graalvm.word.UnsignedWord
import java.io.InputStream
import java.io.OutputStream
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference
import java.util.concurrent.locks.ReentrantLock
import java.util.stream.Stream
import kotlin.io.path.Path
import elide.annotations.Inject
import elide.annotations.Singleton
import elide.runtime.LogLevel
import elide.runtime.Logger
import elide.runtime.Logging
import elide.runtime.gvm.ExecutionInputs
import elide.runtime.gvm.cfg.GuestVMConfiguration
import elide.runtime.gvm.internals.VMProperty
import elide.util.RuntimeFlag
import org.graalvm.polyglot.Context as VMContext
import elide.runtime.gvm.internals.VMStaticProperty as StaticProperty

import java.util.logging.Handler
import java.util.logging.Level
import java.util.logging.LogRecord

/** TBD. */
@Singleton internal class NativeContextManagerImpl @Inject constructor (config: GuestVMConfiguration) :
  ContextManager<VMContext, VMContext.Builder> {
  private companion object {
    // Whether to enable Isolates.
    const val enableIsolates = false

    // Whether to enable the auxiliary cache.
    const val enableAuxiliaryCache = false

    // Flipped if we're building or running a native image.
    private val isNativeImage = ImageInfo.inImageCode()

    // Whether the auxiliary cache is effectively enabled.
    private val auxCache = (
      enableAuxiliaryCache &&
      isNativeImage &&
      System.getProperty("elide.test") != "true" &&
      System.getProperty("ELIDE_TEST") != "true" &&
      System.getProperty("elide.vm.engine.preinitialize") != "false" &&  // manual killswitch
      !ImageInfo.isSharedLibrary() &&
      !Platform.includedIn(Platform.LINUX_AMD64::class.java) &&  // disabled to prefer G1GC on linux AMD64
      !Platform.includedIn(Platform.WINDOWS::class.java)  // disabled on windows - not supported
    )

    // Static options which are supplied to the engine.
    private val staticEngineOptions = listOfNotNull(
      StaticProperty.active("engine.BackgroundCompilation"),
      StaticProperty.active("engine.UsePreInitializedContext"),
      StaticProperty.active("engine.OSR"),
      StaticProperty.active("engine.Compilation"),
      StaticProperty.active("engine.MultiTier"),
      StaticProperty.active("engine.Splitting"),
      StaticProperty.of("engine.Mode", "latency"),  // @TODO(sgammon): swap for throughput in server mode
      StaticProperty.activeWhenAtMost("23.0", "engine.Inlining"),
      StaticProperty.activeWhenAtMost("23.0", "engine.InlineAcrossTruffleBoundary"),
      StaticProperty.activeWhenAtLeast("23.1", "compiler.Inlining"),
      StaticProperty.activeWhenAtLeast("23.1", "compiler.EncodedGraphCache"),
      StaticProperty.activeWhenAtLeast("23.1", "compiler.InlineAcrossTruffleBoundary"),
      StaticProperty.inactiveWhenAtLeast("23.1", "engine.WarnOptionDeprecation"),

      // isolate options
      if (!enableIsolates) null else StaticProperty.inactive("engine.SpawnIsolate"),
      if (!enableIsolates) null else StaticProperty.of("engine.UntrustedCodeMitigation", "none"),
      if (!enableIsolates) null else StaticProperty.of("engine.MaxIsolateMemory", "2GB"),

      // if we're running in a native image, enabled the code compile cache
      if (!auxCache) null else StaticProperty.of("engine.PreinitializeContexts", "js"),
      if (!auxCache) null else StaticProperty.active("engine.CachePreinitializeContext"),
      if (!auxCache) null else StaticProperty.of("engine.CacheCompile", "hot"),
      if (!auxCache) null else StaticProperty.of("engine.Cache",
        Path("/", "tmp", "elide-${ProcessHandle.current().pid()}.vmcache").toAbsolutePath().toString()
      ),

      // enable debug features if so instructed
      if (!RuntimeFlag.inspectSuspend) null else StaticProperty.active("inspect.Suspend"),
      if (!RuntimeFlag.inspectWait) null else StaticProperty.active("inspect.WaitAttached"),
      if (!RuntimeFlag.inspectInternal) null else StaticProperty.active("inspect.Internal"),

      when {
        RuntimeFlag.inspect && RuntimeFlag.inspectHost.isNotBlank() && RuntimeFlag.inspectPort > 0 ->
          StaticProperty.of("inspect", "${RuntimeFlag.inspectHost}:${RuntimeFlag.inspectPort}")

        RuntimeFlag.inspect && RuntimeFlag.inspectHost.isNotBlank() ->
          StaticProperty.of("inspect", "localhost:${RuntimeFlag.inspectPort}:4200")

        RuntimeFlag.inspect && RuntimeFlag.inspectPort > 0 ->
          StaticProperty.of("inspect", "localhost:${RuntimeFlag.inspectPort}")

        else -> if (!RuntimeFlag.inspect) null else StaticProperty.active("inspect")
      },
    )

    // Size of the disruptor ring buffer for each VM executor.
    private const val ringBufferSize = 32

    // Number of retries to apply to the sleeping-wait strategy.
    private const val sleepingRetries: Int = 200

    // Default thread-sleep (in nanoseconds).
    private const val defaultSleepNs: Long = 100L
  }

  // Engine logger to use.
  private val engineLog: Logger = Logging.named("elide:engine")

  /** Stubbed output stream. */
  private class StubbedOutputStream : OutputStream() {
    companion object {
      /** Singleton instance for internal use. */
      internal val SINGLETON = StubbedOutputStream()
    }

    override fun write(b: Int): Unit = error(
      "Cannot write to stubbed stream from inside a guest VM."
    )
  }

  /** Stubbed input stream. */
  private class StubbedInputStream : InputStream() {
    companion object {
      /** Singleton instance for internal use. */
      internal val SINGLETON = StubbedInputStream()
    }

    override fun read(): Int = error(
      "Cannot read from stubbed stream from inside a guest VM."
    )
  }

  /** Implements a thread local which binds a native VM thread to an exclusive VM context. */
  private inner class VMThreadLocal : ThreadLocal<VMContext?>() {
    override fun initialValue(): VMContext? = null
  }

  /** Thread implementation for a unit of guest VM work. */
//  private inner class NativeVMThread constructor (
//    private val operation: VMContext.() -> Unit,
//  ) : Thread() {
//    /** Execution lock for this thread. */
//    private val mutex = ReentrantLock()
//
//    /** Last-seen exception. */
//    private val lastException: AtomicReference<Throwable?> = AtomicReference(null)
//
//    // Prepare to enter the VM context.
//    private fun preExecute(context: VMContext) {
//      context.enter()
//    }
//
//    // Clean up after exiting the VM context.
//    private fun postExecute(context: VMContext) {
//      context.leave()
//    }
//
//    // Lock for execution.
//    private fun withLock(op: (VMContext) -> Unit) {
//      val ctx = workerContext.get() ?: error("Failed to acquire VM context")
//      mutex.lock()
//      try {
//        op.invoke(ctx)
//      } catch (err: Throwable) {
//        lastException.set(err)
//      } finally {
//        mutex.unlock()
//      }
//    }
//
//    /**
//     * TBD.
//     */
//    override fun run(): Unit = withLock {
//      try {
//        preExecute(it)
//        operation.invoke(it)
//      } finally {
//        postExecute(it)
//      }
//    }
//  }

  /**
   * TBD.
   */
  internal inner class NativeVMInvocation<Inputs: ExecutionInputs> : ContextManager.VMInvocation<Inputs> {
    // Nothing at this time.
  }

  /**
   * TBD.
   */
  private inner class VMInvocationFactory<Inputs: ExecutionInputs> : EventFactory<NativeVMInvocation<Inputs>> {
    override fun newInstance(): NativeVMInvocation<Inputs> = NativeVMInvocation()
  }

  /**
   * TBD.
   */
  private inner class NativeVMExecutor<I: ExecutionInputs> :
    EventHandler<NativeVMInvocation<I>>,
    LifecycleAware,
    AutoCloseable {
    /** Last-seen exception. */
    private val threadId: AtomicLong = AtomicLong(-1)

    /** Last-seen exception. */
    private lateinit var threadName: String

    /** Execution lock for this thread. */
    private val mutex = ReentrantLock()

    /** Last-seen exception. */
    private val lastException: AtomicReference<Throwable?> = AtomicReference(null)

    // Initialize VM context for this executor.
    private fun initializeVMContext() {
      val thread = Thread.currentThread()
      logging.debug { "Allocating VM context for thread '${thread.name}'" }
      val ctx = allocateContext()
      logging.trace { "Context ready for VM thread '${thread.name}'" }
      workerContext.set(ctx)
      threadId.set(thread.id)
      threadName = thread.name
      logging.trace { "VM worker initialized for thread '${thread.name}'" }
    }

    override fun close() {
      try {
        logging.debug("Closing executor context: $threadName")
        val ctx = workerContext.get()
        if (ctx == null) {
          logging.warn("Context already de-allocated")
          return
        }
        ctx.close(true)
        logging.trace("VM context closed: $threadName")
      } catch (err: Throwable) {
        logging.error("Unhandled exception while closing VM context", err)
      }
    }

    override fun onStart() {
      try {
        initializeVMContext()
      } catch (err: Throwable) {
        error("Failed to initialize VM context: $err")
      }
    }

    override fun onShutdown() = close()

    // Prepare to enter the VM context.
    private fun preExecute(context: VMContext) {
      if (logging.isEnabled(LogLevel.TRACE))
        logging.trace("Entering VM execution context: $threadName")
      context.enter()
    }

    // Clean up after exiting the VM context.
    private fun postExecute(context: VMContext) {
      if (logging.isEnabled(LogLevel.TRACE))
        logging.trace("Leaving VM execution context: $threadName")
      context.leave()
    }

    // Lock for execution.
    private fun withLock(op: (VMContext) -> Unit) {
      logging.trace { "Acquiring locked execution context: $threadName" }
      val ctx = workerContext.get() ?: error("Failed to acquire VM context")
      mutex.lock()
      try {
        preExecute(ctx)
        op.invoke(ctx)
      } catch (err: Throwable) {
        lastException.set(err)
      } finally {
        postExecute(ctx)
        mutex.unlock()
      }
    }

    override fun onEvent(event: NativeVMInvocation<I>, sequence: Long, endOfBatch: Boolean) {
      TODO("Not yet implemented")
    }
  }

  // Private logger.
  private val logging: Logger = Logging.of(NativeContextManagerImpl::class)

  // Atomic reference to the globally-active Engine.
  private val engine: AtomicReference<Engine> = AtomicReference(null)

  // Whether the engine has initialized.
  private val initialized: AtomicReference<Boolean> = AtomicReference(false)

  // Context factory function.
  private val contextFactory: AtomicReference<(Engine) -> VMContext.Builder> = AtomicReference(null)

  // Effective (primary language) context spawn function.
  private val contextSpawn: AtomicReference<(VMContext.Builder) -> VMContext> = AtomicReference(null)

  // Context configuration function.
  private val contextConfigure: MutableList<(VMContext.Builder) -> Unit> = ArrayList()

  // Counter for VM thread spawns.
  private val threadCounter: AtomicInteger = AtomicInteger(0)

  // Thread-local VM execution context.
  private val workerContext: VMThreadLocal = VMThreadLocal()

  // Factory for VM invocation events.
  private val invocationEventFactory: VMInvocationFactory<ExecutionInputs> = VMInvocationFactory()

  // Main VM executor.
  private val vmExecutor: NativeVMExecutor<ExecutionInputs> = NativeVMExecutor()

  // Additional properties to apply to created contexts.
  private val additionalProperties: MutableSet<VMProperty> = TreeSet()

  init {
    // Acquire a global engine singleton.
    engine.set(
      Engine.newBuilder(*(config.languages ?: GuestVMConfiguration.DEFAULT_LANGUAGES).toTypedArray()).apply {
        // stub streams
        if (System.getProperty("elide.js.vm.enableStreams", "false") != "true") {
          `in`(StubbedInputStream.SINGLETON)
          out(StubbedOutputStream.SINGLETON)
          err(StubbedOutputStream.SINGLETON)
        }

        // forbid system property overrides
        useSystemProperties(false)

        // assign core log handler
        logHandler(GuestLogProxy.wrapping(engineLog))

        // allow experimental options
        allowExperimentalOptions(true).let {
          // Apply static engine options.
          staticEngineOptions.fold(it) { builder, property ->
            builder.option(property.symbol, property.value())
          }
        }
      }.build()
    )
  }

  // Allocate a new thread-confined VM execution context.
  private fun allocateContext(builder: ((VMContext.Builder) -> Unit)? = null): VMContext {
    val fresh = contextFactory.get().invoke(
      engine()
    )

    // apply properties installed via `configureVM`
    if (additionalProperties.isNotEmpty()) {
      logging.debug("Applying ${additionalProperties.size} additional VM properties")
      additionalProperties.mapNotNull {
        val value = it.value()
        if (value == null) {
          null
        } else {
          it to value
        }
      }.forEach {
        fresh.option(it.first.symbol, it.second)
      }
    } else {
      logging.trace("No additional VM properties to apply")
    }

    // let the call-level builder have a chance to configure things
    builder?.invoke(fresh)

    // finalize the new context and return
    contextConfigure.forEach {
      it.invoke(fresh)
    }
    return contextSpawn.get().invoke(fresh)
  }

  override fun configureVM(props: Stream<VMProperty>) {
    check(!initialized.get()) {
      "Cannot configure VM context properties after initialization"
    }
    props.forEach {
      additionalProperties.add(it)
    }
  }

  override fun installContextFactory(factory: (Engine) -> VMContext.Builder) {
    logging.trace("VM installed context factory")
    contextFactory.set(factory)
  }

  override fun installContextConfigurator(factory: (Builder) -> Unit) {
    logging.trace("VM installed context spawn")
    contextConfigure.add(factory)
  }

  override fun installContextSpawn(factory: (VMContext.Builder) -> VMContext) {
    logging.trace("VM installed context spawn")
    contextSpawn.set(factory)
  }

  override fun activate(start: Boolean) {
    logging.trace("Activating native VM context manager")
    initialized.compareAndSet(
      false,
      true,
    )
  }

  override fun engine(): Engine = engine.get()

  override fun <R> executeAsync(operation: VMContext.() -> R): CompletableFuture<R> {
    TODO("not yet implemented")
  }

  override fun <R> acquire(builder: ((VMContext.Builder) -> Unit)?, operation: VMContext.() -> R): R {
    return allocateContext(builder).let { ctx ->
      try {
        ctx.enter()
        operation.invoke(ctx)
      } finally {
        ctx.leave()
      }
    }
  }
}
