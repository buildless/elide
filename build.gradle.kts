@file:Suppress(
  "UnstableApiUsage",
  "unused",
  "DSL_SCOPE_VIOLATION",
)

import java.util.Properties

plugins {
  id("project-report")
  id("org.jetbrains.dokka")
  id("org.sonarqube")
  id("org.jetbrains.kotlinx.kover")
  id("io.gitlab.arturbosch.detekt")
  alias(libs.plugins.qodana)
  alias(libs.plugins.ktlint)
  alias(libs.plugins.doctor)
  jacoco
  signing
}

group = "dev.elide"

// Set version from `.version` if stamping is enabled.
version = if (project.hasProperty("elide.stamp") && project.properties["elide.stamp"] == "true") {
  file(".version").readText().trim().replace("\n", "").ifBlank {
    throw IllegalStateException("Failed to load `.version`")
  }
} else if (project.hasProperty("version")) {
  project.properties["version"] as String
} else {
  "1.0-SNAPSHOT"
}

val props = Properties()
props.load(file(if (project.hasProperty("elide.ci") && project.properties["elide.ci"] == "true") {
  "gradle-ci.properties"
} else {
  "local.properties"
}).inputStream())

val isCI = project.hasProperty("elide.ci") && project.properties["elide.ci"] == "true"

val javaLanguageVersion = project.properties["versions.java.language"] as String
val kotlinLanguageVersion = project.properties["versions.kotlin.language"] as String
val ecmaVersion = project.properties["versions.ecma.language"] as String

// List of code samples to consider for official builds and testing.
val samplesList = listOf(
  ":samples:server:hellocss",
  ":samples:server:helloworld",
  ":samples:fullstack:basic:server",
  ":samples:fullstack:react:server",
  ":samples:fullstack:ssr:server",
  ":samples:fullstack:react-ssr:server",
)

tasks.dokkaHtmlMultiModule.configure {
  includes.from("README.md")
  outputDirectory.set(buildDir.resolve("docs/kotlin/html"))
}

tasks.create("docs") {
  dependsOn(listOf(
    "dokkaHtmlMultiModule",
    "dokkaGfmMultiModule",
    ":packages:graalvm:dokkaJavadoc",
    ":packages:rpc-jvm:dokkaJavadoc",
    ":packages:server:dokkaJavadoc",
  ))
}

buildscript {
  repositories {
    maven("https://maven-central.storage-download.googleapis.com/maven2/")
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
  }
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.sdk.get()}")
    if (project.hasProperty("elide.pluginMode") && project.properties["elide.pluginMode"] == "repository") {
      classpath("dev.elide.buildtools:plugin:${project.properties["elide.pluginVersion"] as String}")
    }
  }
  if (project.property("elide.lockDeps") == "true") {
    configurations.classpath {
      resolutionStrategy.activateDependencyLocking()
    }
  }
}

tasks.register("relock") {
  dependsOn(
    *(subprojects.map {
      it.tasks.named("dependencies")
    }.toTypedArray())
  )
}

sonarqube {
  properties {
    property("sonar.projectKey", "elide-dev_v3")
    property("sonar.organization", "elide-dev")
    property("sonar.host.url", "https://sonarcloud.io")
    property("sonar.dynamicAnalysis", "reuseReports")
    property("sonar.junit.reportsPath", "build/reports/")
    property("sonar.java.coveragePlugin", "jacoco")
    property("sonar.sourceEncoding", "UTF-8")
    property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/kover/merged/xml/report.xml")
  }
}

val dokkaVersion = libs.versions.dokka.get()
val mermaidDokka = "0.4.1"

subprojects {
  val name = this.name

  apply {
    plugin("io.gitlab.arturbosch.detekt")
    plugin("org.jlleitschuh.gradle.ktlint")
    plugin("org.sonarqube")
    plugin("org.jetbrains.dokka")
  }

  val dokkaPlugin by configurations
  dependencies {
    dokkaPlugin("org.jetbrains.dokka:versioning-plugin:$dokkaVersion")
    dokkaPlugin("org.jetbrains.dokka:templating-plugin:$dokkaVersion")
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:$dokkaVersion")
//    dokkaPlugin("com.glureau:html-mermaid-dokka-plugin:$mermaidDokka")
  }

  sonarqube {
    if (name != "base" && name != "test" && name != "model" && name != "bom" && name != "ssg") {
      properties {
        property("sonar.sources", "src/main/kotlin")
        property("sonar.tests", "src/test/kotlin")
        property(
          "sonar.coverage.jacoco.xmlReportPaths",
          listOf(
            "build/reports/jacoco/testCodeCoverageReport/testCodeCoverageReport.xml",
            "build/reports/jacoco/testCodeCoverageReport/jacocoTestReport.xml",
            "build/reports/jacoco/test/jacocoTestReport.xml",
            "build/reports/kover/xml/coverage.xml",
          )
        )
        if (name == "server" || name == "proto" || name == "model") {
          property("sonar.java.binaries", "build/classes/java/main,build/classes/kotlin/main")
        }
      }
    } else if (name == "bom" || name == "ssg") {
      // nothing
    } else {
      properties {
        property("sonar.sources", "src/commonMain/kotlin,src/jvmMain/kotlin,src/jsMain/kotlin,src/nativeMain/kotlin")
        property("sonar.tests", "src/commonTest/kotlin,src/jvmTest/kotlin,src/jsTest/kotlin,src/nativeTest/kotlin")
        property("sonar.java.binaries", "build/classes/kotlin/jvm/main")
        property(
          "sonar.coverage.jacoco.xmlReportPaths",
          listOf(
            "build/reports/jacoco/testCodeCoverageReport/testCodeCoverageReport.xml",
            "build/reports/jacoco/testCodeCoverageReport/jacocoTestReport.xml",
            "build/reports/jacoco/test/jacocoTestReport.xml",
            "build/reports/kover/xml/coverage.xml",
          )
        )
      }
    }
  }

  ktlint {
    debug.set(false)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    ignoreFailures.set(true)
    enableExperimentalRules.set(true)
    filter {
      exclude("**/generated/**")
      exclude("**/tools/plugin/gradle-plugin/**")
      include("**/kotlin/**")
    }
  }

  detekt {
    ignoreFailures = true
    config = rootProject.files("config/detekt/detekt.yml")
  }

  afterEvaluate {
    if (tasks.findByName("check") != null) {
      tasks.getByName("check") {
        setDependsOn(dependsOn.filterNot {
          it is TaskProvider<*> && it.name == "detekt"
        })
      }

      tasks.getByName("build") {
        setDependsOn(dependsOn.filterNot {
          it is TaskProvider<*> && it.name == "check"
        })
      }
    }
  }

  if (project.property("elide.lockDeps") == "true") {
    dependencyLocking {
      lockAllConfigurations()
    }
  }
}

allprojects {
  repositories {
    maven("https://maven-central.storage-download.googleapis.com/maven2/")
    mavenCentral()
    google()
  }
}

tasks.register("resolveAndLockAll") {
  doFirst {
    require(gradle.startParameter.isWriteDependencyLocks)
  }
  doLast {
    configurations.filter {
      // Add any custom filtering on the configurations to be resolved
      it.isCanBeResolved
    }.forEach { it.resolve() }
  }
}

tasks.named<HtmlDependencyReportTask>("htmlDependencyReport") {
  projects = project.allprojects
}

if (tasks.findByName("resolveAllDependencies") == null) {
  tasks.register("resolveAllDependencies") {
    val npmInstall = tasks.findByName("kotlinNpmInstall")
    if (npmInstall != null) {
      dependsOn(npmInstall)
    }
    doLast {
      allprojects {
        configurations.forEach { c ->
          if (c.isCanBeResolved) {
            println("Downloading dependencies for '$path' - ${c.name}")
            val result = c.incoming.artifactView { lenient(true) }.artifacts
            result.failures.forEach {
              println("- Ignoring Error: ${it.message}")
            }
          }
        }
      }
    }
  }
}

koverMerged {
  enable()

  xmlReport {
    onCheck.set(isCI)
  }

  htmlReport {
    onCheck.set(isCI)
  }
}

tasks.register("samples") {
  description = "Build and test all built-in code samples, in the `samples` path and with Knit."

  dependsOn(
    "buildSamples",
    "testSamples",
    "nativeTestSamples",
  )
}

tasks.register("buildSamples") {
  description = "Assemble all sample code."

  samplesList.forEach {
    dependsOn("$it:assemble")
  }
}

tasks.register("testSamples") {
  description = "Run all tests for sample code."

  samplesList.forEach {
    dependsOn("$it:test")
  }
}

tasks.register("nativeTestSamples") {
  description = "Run native (GraalVM) tests for sample code."

  samplesList.forEach {
    dependsOn("$it:nativeTest")
  }
}

tasks.register("reports") {
  description = "Build all reports."

  dependsOn(
    ":dependencyReport",
    ":htmlDependencyReport",
  )
}

tasks.register("preMerge") {
  description = "Runs all the tests/verification tasks"

  dependsOn(
    ":reports",
    ":detekt",
    ":ktlintCheck",
    ":check",
  )
}
