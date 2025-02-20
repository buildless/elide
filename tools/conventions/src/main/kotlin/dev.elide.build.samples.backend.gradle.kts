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

@file:Suppress("UnstableApiUsage")

plugins {
  id("io.micronaut.application")
  id("io.micronaut.aot")
  id("io.micronaut.graalvm")
  id("io.micronaut.docker")
  id("dev.elide.build.jvm.kapt")
  id("dev.elide.build.docker")
}

val quickbuild = (
  project.properties["elide.release"] != "true" ||
  project.properties["elide.buildMode"] == "dev"
)

graalvmNative {
  testSupport = true

  metadataRepository {
    enabled = true
    version = GraalVMVersions.graalvmMetadata
  }

  agent {
    defaultMode = "standard"
    builtinCallerFilter = true
    builtinHeuristicFilter = true
    enableExperimentalPredefinedClasses = false
    enableExperimentalUnsafeAllocationTracing = false
    trackReflectionMetadata = true
    enabled = true

    modes {
      standard {}
    }
    metadataCopy {
      inputTaskNames.add("test")
      outputDirectories.add("src/main/resources/META-INF/native-image")
      mergeWithExisting = true
    }
  }

  binaries {
    named("main") {
      fallback = false
      sharedLibrary = false
      quickBuild = quickbuild
    }

    named("test") {
      quickBuild = quickbuild
    }
  }
}

tasks.withType<Tar> {
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType<Zip>{
  duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.named<io.micronaut.gradle.docker.MicronautDockerfile>("dockerfile") {
  baseImage("${project.properties["elide.publish.repo.docker.tools"]}/base:latest")
}

tasks.named<io.micronaut.gradle.docker.MicronautDockerfile>("optimizedDockerfile") {
  baseImage("${project.properties["elide.publish.repo.docker.tools"]}/runtime/jvm17")
}

tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
  graalImage = "${project.properties["elide.publish.repo.docker.tools"]}/builder:latest"
  baseImage("${project.properties["elide.publish.repo.docker.tools"]}/runtime/native:latest")
  args("-H:+StaticExecutableWithDynamicLibC")
}

tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("optimizedDockerfileNative") {
  graalImage = "${project.properties["elide.publish.repo.docker.tools"]}/builder:latest"
  baseImage("${project.properties["elide.publish.repo.docker.tools"]}/runtime/native:latest")
  args("-H:+StaticExecutableWithDynamicLibC")
}

tasks.named<JavaExec>("run") {
  val argsList = ArrayList<String>()
  jvmArgs(listOf(
    "-Delide.dev=true",
  ))
  if (project.hasProperty("elide.vm.inspect") && project.properties["elide.vm.inspect"] == "true") {
    argsList.add("--elide.vm.inspect=true")
  } else {
    argsList.add("--elide.vm.inspect=false")
  }
  @Suppress("SpreadOperator")
  args(
    *argsList.toTypedArray()
  )
}
