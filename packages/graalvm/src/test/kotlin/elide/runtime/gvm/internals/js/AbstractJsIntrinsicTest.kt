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

@file:Suppress("MemberVisibilityCanBePrivate", "SameParameterValue")

package elide.runtime.gvm.internals.js

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Engine
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import java.util.function.Function
import kotlinx.coroutines.runBlocking
import elide.annotations.Inject
import elide.runtime.gvm.internals.AbstractIntrinsicTest
import elide.runtime.gvm.internals.context.ContextManager
import elide.runtime.intrinsics.GuestIntrinsic
import elide.runtime.intrinsics.Symbol
import elide.vm.annotations.Polyglot
import org.graalvm.polyglot.Context as VMContext
import org.graalvm.polyglot.Value as GuestValue

/** Abstract base for JS intrinsics. */
internal abstract class AbstractJsIntrinsicTest<T : GuestIntrinsic>(
  private val testInject: Boolean = true,
) : AbstractIntrinsicTest<T>() {
  companion object {
    init {
      System.setProperty("elide.js.vm.enableStreams", "true")
    }
  }

  private val initialized: AtomicBoolean = AtomicBoolean(false)

  // Guest context manager.
  @Inject lateinit var contextManager: ContextManager<Context, Context.Builder>

  // JS runtime.
  @Inject lateinit var jsvm: JsRuntime

  // Build a customized guest context from scratch.
  override fun buildContext(engine: Engine, conf: (Context.Builder.() -> Unit)?): Context.Builder {
    throw UnsupportedOperationException("not supported for this test case")
  }

  // Prepare an operation with a customized guest context.
  override fun <V : Any> withContext(op: Context.() -> V, conf: (Context.Builder.() -> Unit)?): V {
    throw UnsupportedOperationException("not supported for this test case")
  }

  // Run the provided `op` with an active (and exclusively owned) JS VM context.
  override fun <V: Any> withContext(op: VMContext.() -> V): V = runBlocking {
    if (!initialized.get()) {
      contextManager.installContextFactory {
        jsvm.builder(it)
      }
      contextManager.installContextConfigurator {
        jsvm.configureVM(it)
      }
      contextManager.installContextSpawn {
        jsvm.spawn(it)
      }
      contextManager.activate(start = false)
      initialized.set(true)
    }
    contextManager {
      op.invoke(this)
    }
  }

  /** Assertion capture interface. */
  @FunctionalInterface internal interface JsAssertion : TestAssertion, Function<Any?, TestContext> {
    /** Invoke a null-check-based assertion. */
    @Polyglot override fun apply(value: Any?): TestContext
  }

  /** Default top-level assertion implementation. */
  internal class CaptureAssertion : JsAssertion {
    private val heldValue: AtomicReference<Any?> = AtomicReference(null)
    override val value: Any? get() = heldValue.get()
    @Polyglot override fun apply(value: Any?): TestContext {
      heldValue.set(value)
      return TestResultContext(this)
    }
  }

  // Logic to execute a guest-side test.
  private inline fun executeGuestInternal(
    ctx: VMContext,
    bind: Boolean,
    bindUtils: Boolean,
    op: VMContext.() -> String,
  ): GuestValue {
    // resolve the script
    val script = op.invoke(ctx)

    // prep intrinsic bindings under test
    val bindings = if (bind) {
      val target = HashMap<Symbol, Any>()
      provide().install(GuestIntrinsic.MutableIntrinsicBindings.Factory.wrap(target))
      target
    } else {
      emptyMap()
    }

    // install bindings under test, if directed
    val target = ctx.getBindings("js")
    bindings.forEach {
      target.putMember(it.key.symbol, it.value)
    }

    // install utility bindings, if directed
    if (bindUtils) {
      target.putMember("test", CaptureAssertion())
    }

    // prep for execution
    val hasErr = AtomicBoolean(false)
    val subjectErr: AtomicReference<Throwable> = AtomicReference(null)

    // execute script
    val returnValue = try {
      ctx.enter()
      ctx.eval("js", script)
    } catch (err: Throwable) {
      hasErr.set(true)
      subjectErr.set(err)
      throw subjectErr.get()
    } finally {
      ctx.leave()
    }
    return returnValue
  }

  // Run the provided factory to produce a script, then run that test within a warmed `Context`.
  override fun executeGuest(bind: Boolean, op: VMContext.() -> String) = GuestTestExecution(::withContext) {
    executeGuestInternal(
      this,
      bind,
      bindUtils = true,
      op,
    )
  }

  // Run the provided `op` on the host, and the provided `guest` via `executeGuest`.
  protected fun executeDual(op: () -> Unit, guest: VMContext.() -> String) = executeDual(true, op, guest)

  // Run the provided `op` on the host, and the provided `guest` via `executeGuest`.
  protected fun executeDual(
    bind: Boolean,
    op: () -> Unit,
    guest: VMContext.() -> String,
  ) = GuestTestExecution(::withContext) {
    op.invoke()
    executeGuestInternal(
      this,
      bind,
      bindUtils = true,
      guest,
    )
  }

  // Run the provided `op` on the host, and the provided `guest` via `executeGuest`.
  override fun dual(bind: Boolean, op: () -> Unit): DualTestExecutionProxy {
    op.invoke()
    return object : DualTestExecutionProxy() {
      override fun guest(guestOperation: Context.() -> String) = GuestTestExecution(::withContext) {
        executeGuestInternal(
          this,
          bind,
          bindUtils = true,
          guestOperation,
        )
      }.doesNotFail()

      override fun thenRun(guestOperation: Context.() -> String) = GuestTestExecution(::withContext) {
        executeGuestInternal(
          this,
          bind,
          bindUtils = true,
          guestOperation,
        )
      }
    }
  }
}
