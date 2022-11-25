@file:Suppress(
  "UnstableApiUsage",
  "unused",
  "UNUSED_VARIABLE",
  "DSL_SCOPE_VIOLATION",
)

plugins {
  `build-dashboard`
  id("project-report")
  id("test-report-aggregation")
  id("jacoco-report-aggregation")
  id("org.sonarqube")
  id("org.jetbrains.kotlinx.kover")
}

val antJUnit: Configuration by configurations.creating

kover {
  isDisabled.set(true)
}

reporting {
  reports {
    val testAggregateTestReport by creating(AggregateTestReport::class) {
      testType.set(TestSuiteType.UNIT_TEST)
    }
    val testCodeCoverageReport by creating(JacocoCoverageReport::class) {
      testType.set(TestSuiteType.UNIT_TEST)
      reportTask {
        reports {
          xml.required.set(true)
        }
      }
    }
  }
}

dependencies {
  Elide.serverModules.plus(
    Elide.multiplatformModules
  ).plus(
    Elide.frontendModules
  ).forEach {
    testReportAggregation(project(":packages:$it"))
    jacocoAggregation(project(":packages:$it"))
  }

  antJUnit("org.apache.ant", "ant-junit", Versions.antJUnit)
}

task<Copy>("locateCopyJUnitReports") {
  val testReportPaths: List<String> = rootProject.allprojects.map {
    val path = file("${it.buildDir}/test-results/test")
    if (path.exists()) {
      java.util.Optional.of(path)
    } else {
      java.util.Optional.empty()
    }
  }.filter {
    it.isPresent
  }.map {
    it.get().absolutePath
  }

  testReportPaths.forEach {
    from(it) {
      include("TEST-*.xml")
      include("**/TEST-*.xml")
    }
  }
  into(
    "build/test-results/allreports"
  )
}

task("mergeJUnitReports") {
  dependsOn(tasks.named("locateCopyJUnitReports"))
  val resultsDir = file("build/test-results/allreports")
  val mergedDir = file("build/test-results")

  if (resultsDir.exists()) {
    doLast {
      ant.withGroovyBuilder {
        "taskdef"(
          "name" to "junitreport",
          "classname" to "org.apache.tools.ant.taskdefs.optional.junit.XMLResultAggregator",
          "classpath" to antJUnit.asPath
        )

        // generates an XML report
        "junitreport"("todir" to mergedDir) {
          "fileset"(
            "dir" to resultsDir,
            "includes" to "TEST-*.xml"
          )
        }
      }
    }
  }
}

tasks.create("reports") {
  dependsOn(tasks.named<TestReport>("testAggregateTestReport"))
  dependsOn(tasks.named<JacocoReport>("testCodeCoverageReport"))
  dependsOn(tasks.named("mergeJUnitReports"))
}

tasks {
  buildDashboard {
    // Nothing at this time.
  }
}
