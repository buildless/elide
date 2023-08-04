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

// automatically generated by the FlatBuffers compiler, do not modify

package elide.meta

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class EndpointOptions : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : EndpointOptions {
        __init(_i, _bb)
        return this
    }
    val stateful : Boolean
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val precompilable : Boolean
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsEndpointOptions(_bb: ByteBuffer): EndpointOptions = getRootAsEndpointOptions(_bb, EndpointOptions())
        fun getRootAsEndpointOptions(_bb: ByteBuffer, obj: EndpointOptions): EndpointOptions {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createEndpointOptions(builder: FlatBufferBuilder, stateful: Boolean, precompilable: Boolean) : Int {
            builder.startTable(2)
            addPrecompilable(builder, precompilable)
            addStateful(builder, stateful)
            return endEndpointOptions(builder)
        }
        fun startEndpointOptions(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addStateful(builder: FlatBufferBuilder, stateful: Boolean) = builder.addBoolean(0, stateful, false)
        fun addPrecompilable(builder: FlatBufferBuilder, precompilable: Boolean) = builder.addBoolean(1, precompilable, false)
        fun endEndpointOptions(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
