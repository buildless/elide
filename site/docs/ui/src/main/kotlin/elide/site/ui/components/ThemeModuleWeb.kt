package elide.site.ui.components

import elide.site.ui.theme.Themes
import mui.material.CssBaseline
import mui.material.styles.ThemeProvider
import react.*
import kotlinx.browser.window
import kotlinx.browser.document

const val dynamicTheme = false

/** Get the active [Themes.Mode] from the browser. */
@Suppress("SENSELESS_COMPARISON")
fun currentTheme(): Themes.Mode = if (dynamicTheme) {
  if (window != null) {
    if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
      Themes.Mode.DARK
    } else {
      Themes.Mode.LIGHT
    }
  } else {
    Themes.Mode.LIGHT
  }
} else {
  Themes.Mode.LIGHT
}

/** Theme context provider for browser environments. */
val ThemeModuleWeb = FC<PropsWithChildren> { props ->
  val current = currentTheme().theme
  val state = useState(current)
  val (currentTheme, updater) = state

  useEffectOnce {
    window.matchMedia("(prefers-color-scheme: dark)").addEventListener("change", {
      val themeName = currentTheme().name.lowercase()
      updater(currentTheme().theme)
      document.querySelector("link[sizes~='any']")?.setAttribute(
        "href",
        "/images/favicon.svg?theme=$themeName",
      )
    })
  }

  ThemeContext(state) {
    ThemeProvider {
      theme = currentTheme

      CssBaseline()
      +props.children
    }
  }
}
