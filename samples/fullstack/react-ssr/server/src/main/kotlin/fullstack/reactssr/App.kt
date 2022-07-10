package fullstack.reactssr

import elide.server.*
import elide.server.annotations.Page
import elide.server.controller.PageController
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import kotlinx.css.*
import kotlinx.html.tagext.body
import kotlinx.html.tagext.head
import kotlinx.html.title

/** Self-contained application example, which serves an HTML page, with CSS, that says "Hello, Elide!". */
object App : Application {
  /** GET `/`: Controller for index page. */
  @Page class Index : PageController() {
    // Serve the page itself.
    @Get("/") suspend fun indexPage(request: HttpRequest<*>) = ssr(request) {
      head {
        title { +"Hello, Elide!" }
        stylesheet("/styles/base.css")
        stylesheet("/styles/main.css")
        script("/scripts/ui.js", defer = true)
      }
      body {
        injectSSR(this@Index, request)
      }
    }

    // Serve an embedded asset.
    @Get("/styles/base.css") suspend fun baseStyles(request: HttpRequest<*>) = stylesheet(request) {
      module("styles.base")
    }

    // Serve styles for the page.
    @Get("/styles/main.css") fun styles() = css {
      rule("main") {
        backgroundColor = Color.white
        maxWidth = 600.px
        maxHeight = 800.px
      }
      rule(".sample-app-container") {
        display = Display.flex
        justifyContent = JustifyContent.center
        alignItems = Align.center
      }
    }

    // Serve the built & embedded JavaScript.
    @Get("/scripts/ui.js") fun js() = asset(
      "frontend.js",
      "js",
      MediaType("application/javascript", "js"),
    )
  }

  /** Main entrypoint for the application. */
  @JvmStatic fun main(args: Array<String>) {
    boot(args)
  }
}
