package elide.tool.ssg

import java.util.SortedSet

/**
 * Parameters held internally for the site compiler.
 *
 * @param manifest Path to the manifest to read.
 * @param target Path to the application JAR or running server URL.
 * @param output Compiler output configuration.
 * @param options Options to apply to this compile execution.
 */
public data class SiteCompilerParams(
  public val manifest: String,
  public val target: String,
  public val output: Output,
  public val options: Options,
) {
  /**
   * Compiler output configuration.
   *
   * @param path Path for this output type.
   * @param mode Output mode to use.
   */
  public sealed class Output(
    public open val path: String,
    public val mode: OutputMode,
  ) {
    /** Output to a directory. */
    public data class Directory(
      override val path: String,
    ): Output(path, OutputMode.DIRECTORY)

    /** Output to a file. */
    public data class File(
      override val path: String,
      public val format: OutputFormat,
      public val compressed: Boolean,
    ): Output(path, OutputMode.FILE)

    internal companion object {
      // Determine whether the provided `path` seems like, or is, a directory.
      private fun isDirectory(path: String): Boolean = !path.split("/").last().contains(".")

      // Determine the file output type in file output mode, along with a flag indicating default compression state.
      private fun fileType(path: String): Pair<Boolean, OutputFormat> = when {
        path.endsWith(".zip") -> true to OutputFormat.ZIP
        path.endsWith(".tar") -> false to OutputFormat.TAR
        path.endsWith(".tar.gz") -> true to OutputFormat.TAR
        else -> error("Failed to resolve file extension type '$path' for SSG compiler output")
      }

      /** Create an [Output] spec from the provided [path]. */
      @JvmStatic internal fun fromParams(path: String): Output = if (isDirectory(path)) {
        Directory(path)
      } else {
        val (compressed, format) = fileType(path)
        File(
          path,
          format = format,
          compressed = compressed,
        )
      }
    }
  }

  /** Enumerates supported output modes. */
  public enum class OutputMode {
    /** Output to a directory structure. */
    DIRECTORY,

    /** Output to a file. */
    FILE,
  }

  /** Types of output formats supported by the compiler. */
  public enum class OutputFormat {
    /** Output files to a single zip bundle. */
    ZIP,

    /** Output files to a single tar bundle. */
    TAR,
  }

  /**
   * Options payload for programmatic invocation of the SSG compiler.
   *
   * @param classpath Extra JARs to add to the app execution classpath.
   * @param verbose Whether to emit verbose log messages.
   * @param debug Whether to enable debugging features.
   * @param httpMode Whether to run against the app in HTTP mode.
   * @param ignoreCertErrors Whether to ignore certificate errors.
   * @param crawl Whether to crawl HTML content for additional URLs.
   * @param extraOrigins Extra origins to consider legal for crawling.
   * @param timeout Timeout to apply when executing app requests. Expressed in seconds.
   */
  public data class Options(
    val classpath: String? = null,
    val verbose: Boolean = false,
    val debug: Boolean = false,
    val httpMode: Boolean = false,
    val ignoreCertErrors: Boolean = false,
    val crawl: Boolean = true,
    val extraOrigins: SortedSet<String> = sortedSetOf(),
    val timeout: Int = DEFAULT_REQUEST_TIMEOUT,
  ) {
    public companion object {
      /** Default options. */
      public val DEFAULTS: Options = Options()

      /** Default request timeout, in seconds. */
      public const val DEFAULT_REQUEST_TIMEOUT: Int = 30
    }

    // Apply these options to the provided `compiler` instance.
    internal fun applyTo(compiler: SiteCompiler) {
      compiler.debug = debug
      compiler.verbose = verbose
      compiler.classpath = classpath
      compiler.httpMode = httpMode
      compiler.ignoreCertErrors = ignoreCertErrors
      compiler.extraOrigins = extraOrigins
      compiler.timeout = timeout
    }
  }
}
