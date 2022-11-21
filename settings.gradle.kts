@file:Suppress(
  "UnstableApiUsage",
)

pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

plugins {
  id("com.gradle.enterprise") version("3.11.4")
}

// Fix: Force CWD to proper value and store secondary value.
System.setProperty("user.dir", rootProject.projectDir.toString())
System.setProperty("elide.home", rootProject.projectDir.toString())

val micronautVersion: String by settings

dependencyResolutionManagement {
  repositories {
    maven("https://maven-central.storage-download.googleapis.com/maven2/")
    mavenCentral()
    google()
    maven("https://plugins.gradle.org/m2/")
    maven("https://elide-snapshots.storage-download.googleapis.com/repository/v3/")
  }
  versionCatalogs {
    create("libs") {
      from(files("./gradle/elide.versions.toml"))
    }
    create("mnLibs") {
      from("io.micronaut:micronaut-bom:$micronautVersion")
    }
  }
}

rootProject.name = "elide"

// 1: Gradle convention plugins.
includeBuild("tools/conventions") {
  dependencySubstitution {
    substitute(module("dev.elide.tools:elide-convention-plugins")).using(project(":"))
  }
}

// 2: Kotlin Compiler substrate.
includeBuild("tools/substrate") {
  dependencySubstitution {
    substitute(module("dev.elide.tools:substrate")).using(project(":"))
    substitute(module("dev.elide.tools.kotlin.plugin:injekt-plugin")).using(project(":injekt"))
    substitute(module("dev.elide.tools.kotlin.plugin:interakt-plugin")).using(project(":interakt"))
    substitute(module("dev.elide.tools.kotlin.plugin:redakt-plugin")).using(project(":redakt"))
    substitute(module("dev.elide.tools.kotlin.plugin:sekret-plugin")).using(project(":sekret"))
  }
}

// 3: Build modules.
include(
  ":packages:base",
  ":packages:bom",
  ":packages:frontend",
  ":packages:graalvm",
  ":packages:graalvm-js",
  ":packages:graalvm-react",
  ":packages:model",
  ":packages:platform",
  ":packages:proto",
  ":packages:rpc-js",
  ":packages:rpc-jvm",
  ":packages:server",
  ":packages:ssg",
  ":packages:test",
  ":tools:bundler",
  ":tools:processor",
  ":tools:reports",
)

val buildDocsSite: String by settings
val buildSamples: String by settings
val buildPlugins: String by settings
val buildBenchmarks: String by settings

if (buildPlugins == "true") {
  includeBuild(
    "tools/plugin/gradle-plugin",
  )
}

if (buildSamples == "true") {
  include(
    ":samples:server:hellocss",
    ":samples:server:helloworld",
    ":samples:fullstack:basic:frontend",
    ":samples:fullstack:basic:server",
    ":samples:fullstack:react:frontend",
    ":samples:fullstack:react:server",
    ":samples:fullstack:ssr:node",
    ":samples:fullstack:ssr:server",
    ":samples:fullstack:react-ssr:frontend",
    ":samples:fullstack:react-ssr:node",
    ":samples:fullstack:react-ssr:server",
  )
}

if (buildDocsSite == "true") {
  include(
    ":site:docs:ui",
    ":site:docs:node",
    ":site:docs:app",
  )
}

if (buildBenchmarks == "true") {
  includeBuild("benchmarks")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

val cacheUsername: String? by settings
val cachePassword: String? by settings
val cachePush: String? by settings

buildCache {
  local {
    isEnabled = !(System.getenv("GRADLE_CACHE_REMOTE")?.toBoolean() ?: false)
  }
  remote<HttpBuildCache> {
    isEnabled = System.getenv("GRADLE_CACHE_REMOTE")?.toBoolean() ?: false
    isPush = (cachePush ?: System.getenv("GRADLE_CACHE_PUSH")) == "true"
    url = uri("https://buildcache.dyme.cloud/gradle/cache/")
    credentials {
      username = cacheUsername ?: System.getenv("GRADLE_CACHE_USERNAME") ?: error("Failed to resolve cache username")
      password = cachePassword ?: System.getenv("GRADLE_CACHE_PASSWORD") ?: error("Failed to resolve cache password")
    }
  }
}

enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
