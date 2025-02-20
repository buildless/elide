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

package elide.data

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class DataContainerRef : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : DataContainerRef {
        __init(_i, _bb)
        return this
    }
    val reference : elide.data.DataContainerRef_.ContainerReference? get() = reference(elide.data.DataContainerRef_.ContainerReference())
    fun reference(obj: elide.data.DataContainerRef_.ContainerReference) : elide.data.DataContainerRef_.ContainerReference? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsDataContainerRef(_bb: ByteBuffer): DataContainerRef = getRootAsDataContainerRef(_bb, DataContainerRef())
        fun getRootAsDataContainerRef(_bb: ByteBuffer, obj: DataContainerRef): DataContainerRef {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createDataContainerRef(builder: FlatBufferBuilder, referenceOffset: Int) : Int {
            builder.startTable(1)
            addReference(builder, referenceOffset)
            return endDataContainerRef(builder)
        }
        fun startDataContainerRef(builder: FlatBufferBuilder) = builder.startTable(1)
        fun addReference(builder: FlatBufferBuilder, reference: Int) = builder.addOffset(0, reference, 0)
        fun endDataContainerRef(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
