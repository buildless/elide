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

@file:Suppress("JSFileReferences", "JSUnresolvedFunction", "NpmUsedModulesInstalled")
@file:OptIn(DelicateElideApi::class)

package elide.runtime.gvm.js.vfs

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import kotlin.test.Ignore
import kotlin.test.assertEquals
import elide.runtime.core.DelicateElideApi
import elide.runtime.gvm.internals.vfs.HostVFSImpl
import elide.runtime.gvm.js.AbstractJsTest
import elide.runtime.gvm.vfs.HostVFS
import elide.testing.annotations.Test
import elide.testing.annotations.TestCase
import elide.util.UUID

/** Tests for ESM-style import calls that resolve via host-backed I/O. */
@TestCase @Ignore internal class JsImportHostTest : AbstractJsTest() {
  /** @return Empty VFS instance for testing. */
  private fun tempHostFs() = HostVFS.acquire() as HostVFSImpl
  private val tempdir = Files.createTempDirectory("elide-vfs-${UUID.random()}").toAbsolutePath().toString()

  /** Test: JavaScript `import` call that loads a file from the host file-system. */
  @Test fun testImportHostFs() {
    val fs = tempHostFs()
    val testPath = fs.getPath(tempdir, "test.mjs")
    fs.writeStream(testPath).use { stream ->
      stream.write("export default {sample: \"Hello, ESM!\"};".toByteArray())
    }

    // read the file back to make sure it's there
    val exampleESMContents = fs.readStream(testPath).bufferedReader(StandardCharsets.UTF_8).use {
      it.readText()
    }
    assertEquals("export default {sample: \"Hello, ESM!\"};", exampleESMContents.trim())

    withVFS(fs) {
      // language=javascript
      """
        import testmod from "./test.mjs";
        test(testmod).isNotNull();
        test(testmod.sample).isEqualTo("Hello, ESM!");
      """
    }.doesNotFail()
  }

  /** Test: JavaScript `import` call that loads a file from a nested directory within a host-backed file-system. */
  @Test fun testImportHostFsNested() {
    val fs = tempHostFs()
    fs.createDirectory(fs.getPath(tempdir, "testing"))
    val testPath = fs.getPath(tempdir, "testing/test.mjs")
    fs.writeStream(testPath).use { stream ->
      stream.write("export default {sample: \"Hello, ESM!\"};".toByteArray())
    }

    // read the file back to make sure it's there
    val exampleESMContents = fs.readStream(testPath).bufferedReader(StandardCharsets.UTF_8).use {
      it.readText()
    }
    assertEquals("export default {sample: \"Hello, ESM!\"};", exampleESMContents.trim())

    withVFS(fs) {
      // language=javascript
      """
        import testmod from "./testing/test.mjs";
        test(testmod).isNotNull();
        test(testmod.sample).isEqualTo("Hello, ESM!");
      """
    }.doesNotFail()
  }

  /** Test: JavaScript `import` call that loads a file from the Node modules path. */
  @Test fun testImportHostFsNpmModules() {
    val fs = tempHostFs()
    fs.createDirectory(fs.getPath(tempdir, "node_modules"))
    fs.createDirectory(fs.getPath(tempdir, "node_modules/testing"))

    val testPath = fs.getPath(tempdir, "node_modules/testing/test.mjs")
    val configPath = fs.getPath(tempdir, "node_modules/testing/package.json")

    fs.writeStream(testPath).use { stream ->
      stream.write("export default {sample: \"Hello, ESM!\"};".toByteArray())
    }
    fs.writeStream(configPath).use { stream ->
      stream.write("""
        {
          "name": "testing",
          "version": "1.0.0",
          "main": "./test.mjs",
          "module": true
        }
      """.trimIndent().toByteArray())
    }

    // read the file back to make sure it's there
    val exampleESMContents = fs.readStream(testPath).bufferedReader(StandardCharsets.UTF_8).use {
      it.readText()
    }
    assertEquals("export default {sample: \"Hello, ESM!\"};", exampleESMContents.trim())

    withVFS(fs) {
      // language=javascript
      """
        import testmod from "testing";
        test(testmod).isNotNull();
        test(testmod.sample).isEqualTo("Hello, ESM!");
      """
    }.doesNotFail()
  }
}
