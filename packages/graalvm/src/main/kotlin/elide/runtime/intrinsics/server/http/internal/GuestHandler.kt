package elide.runtime.intrinsics.server.http.internal

import elide.runtime.core.DelicateElideApi
import elide.runtime.core.PolyglotValue
import elide.runtime.intrinsics.server.http.HttpRequest
import elide.runtime.intrinsics.server.http.HttpContext
import elide.runtime.intrinsics.server.http.HttpResponse

/**
 * Lightweight wrapper around a [PolyglotValue] that represents an executable request handler, allowing calls to the
 * underlying guest callable as a normal Kotlin [function][GuestHandlerFunction].
 *
 * Note that using [GuestHandler.of] to wrap a value will verify that it can be executed, but signature checks are not
 * available, meaning that function-like values that don't match a handler's signature are technically possible.
 */
@DelicateElideApi @JvmInline internal value class GuestHandler private constructor(
  private val value: PolyglotValue
) : GuestHandlerFunction {
  override fun invoke(request: HttpRequest, response: HttpResponse, context: HttpContext): Boolean {
    val result = value.execute(request, response, context)

    return when {
      result.isBoolean -> result.asBoolean()
      // don't forward by default
      else -> false
    }
  }
  
  internal companion object {
    /** Wraps a [PolyglotValue] and returns it as a [GuestHandler]. The [value] must be executable. */
    infix fun of(value: PolyglotValue): GuestHandler {
      // we can only verify whether the value is function-like
      require(value.canExecute()) { "Guest handlers must be executable values." }
      return GuestHandler(value)
    }
  }
}