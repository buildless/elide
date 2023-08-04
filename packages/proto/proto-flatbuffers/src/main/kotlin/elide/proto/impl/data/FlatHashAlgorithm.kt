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

@file:Suppress("RedundantVisibilityModifier")

package elide.proto.impl.data

import elide.crypto.HashAlgorithm
import elide.proto.api.Symbolic
import elide.proto.api.Symbolic.Resolver
import elide.proto.api.Symbolic.SymbolUnresolved

/** Maps a native enumeration to each symbolic hash algorithm integer generated by Flatbuffers. */
public enum class FlatHashAlgorithm constructor (override val symbol: HashAlgorithmSymbol) :
  Symbolic<HashAlgorithmSymbol> {
  /** No algorithm at all; just raw, trimmed data. */
  IDENTITY(HashAlgorithm.IDENTITY),

  /** Algorithm: MD5. */
  MD5(HashAlgorithm.MD5),

  /** Algorithm: SHA1. */
  SHA1(HashAlgorithm.SHA1),

  /** Algorithm: SHA-256. */
  SHA256(HashAlgorithm.SHA256),

  /** Algorithm: SHA-512. */
  SHA512(HashAlgorithm.SHA512),

  /** Algorithm: SHA3-224. */
  SHA3_224(HashAlgorithm.SHA3224),

  /** Algorithm: SHA3-256. */
  SHA3_256(HashAlgorithm.SHA3256),

  /** Algorithm: SHA3-512. */
  SHA3_512(HashAlgorithm.SHA3512);

  public companion object : Resolver<HashAlgorithmSymbol, FlatHashAlgorithm> {
    /** @return [FlatHashAlgorithm] corresponding to the provided constant, or throw. */
    @Throws(SymbolUnresolved::class)
    override fun resoleSymbol(symbol: Int): FlatHashAlgorithm = when (symbol) {
      HashAlgorithm.IDENTITY -> IDENTITY
      HashAlgorithm.MD5 -> MD5
      HashAlgorithm.SHA1 -> SHA1
      HashAlgorithm.SHA256 -> SHA256
      HashAlgorithm.SHA512 -> SHA512
      HashAlgorithm.SHA3224 -> SHA3_224
      HashAlgorithm.SHA3256 -> SHA3_256
      HashAlgorithm.SHA3512 -> SHA3_512
      else -> throw unresolved(symbol)
    }
  }
}
