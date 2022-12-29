// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.Context_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class RDFPrefix : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : RDFPrefix {
        __init(_i, _bb)
        return this
    }
    val prefix : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val prefixAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun prefixInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val target : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val targetAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun targetInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsRDFPrefix(_bb: ByteBuffer): RDFPrefix = getRootAsRDFPrefix(_bb, RDFPrefix())
        fun getRootAsRDFPrefix(_bb: ByteBuffer, obj: RDFPrefix): RDFPrefix {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createRDFPrefix(builder: FlatBufferBuilder, prefixOffset: Int, targetOffset: Int) : Int {
            builder.startTable(2)
            addTarget(builder, targetOffset)
            addPrefix(builder, prefixOffset)
            return endRDFPrefix(builder)
        }
        fun startRDFPrefix(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addPrefix(builder: FlatBufferBuilder, prefix: Int) = builder.addOffset(0, prefix, 0)
        fun addTarget(builder: FlatBufferBuilder, target: Int) = builder.addOffset(1, target, 0)
        fun endRDFPrefix(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
