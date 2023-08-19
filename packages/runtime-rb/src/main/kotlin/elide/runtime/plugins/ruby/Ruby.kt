package elide.runtime.plugins.ruby

import elide.runtime.core.DelicateElideApi
import elide.runtime.core.EngineLifecycleEvent.ContextCreated
import elide.runtime.core.EngineLifecycleEvent.ContextInitialized
import elide.runtime.core.EnginePlugin.InstallationScope
import elide.runtime.core.EnginePlugin.Key
import elide.runtime.core.PolyglotContext
import elide.runtime.core.PolyglotContextBuilder
import elide.runtime.core.extensions.disableOptions
import elide.runtime.core.extensions.enableOptions
import elide.runtime.plugins.AbstractLanguagePlugin
import elide.runtime.plugins.AbstractLanguagePlugin.EmbeddedLanguageResources

@DelicateElideApi public class Ruby(
  private val config: RubyConfig,
  private val resources: EmbeddedLanguageResources,
) {
  private fun initializeContext(context: PolyglotContext) {
    // apply init-time settings
    config.applyTo(context)

    // run embedded initialization code
    initializeEmbeddedScripts(context, resources)
  }
  
  private fun configureContext(builder: PolyglotContextBuilder) {
    builder.enableOptions(
      "ruby.embedded",
      "ruby.no-home-provided",
      "ruby.platform-native-interrupt",
      "ruby.platform-native",
      "ruby.polyglot-stdio",
      "ruby.rubygems",
    )
    
    builder.disableOptions(
      "ruby.virtual-thread-fibers",
      "ruby.cexts",
    )
  }
  
  public companion object Plugin : AbstractLanguagePlugin<RubyConfig, Ruby>() {
    private const val RUBY_LANGUAGE_ID = "ruby"
    private const val RUBY_PLUGIN_ID = "Ruby"

    override val languageId: String = RUBY_LANGUAGE_ID
    override val key: Key<Ruby> = Key(RUBY_PLUGIN_ID)

    override fun install(scope: InstallationScope, configuration: RubyConfig.() -> Unit): Ruby {
      // apply the configuration and create the plugin instance
      val config = RubyConfig().apply(configuration)
      val resources = resolveLanguageResources()
      val instance = Ruby(config, resources)

      // subscribe to lifecycle events
      scope.lifecycle.on(ContextCreated, instance::configureContext)
      scope.lifecycle.on(ContextInitialized, instance::initializeContext)

      // register resources with the VFS
      installEmbeddedBundles(scope, resources)

      return instance
    }
  }
}