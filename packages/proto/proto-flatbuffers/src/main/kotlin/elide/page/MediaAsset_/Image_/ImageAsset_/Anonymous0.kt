// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.MediaAsset_.Image_.ImageAsset_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class Anonymous0 : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Anonymous0 {
        __init(_i, _bb)
        return this
    }
    val b64 : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val b64AsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun b64InByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val uri : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val uriAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun uriInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsAnonymous0(_bb: ByteBuffer): Anonymous0 = getRootAsAnonymous0(_bb, Anonymous0())
        fun getRootAsAnonymous0(_bb: ByteBuffer, obj: Anonymous0): Anonymous0 {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createAnonymous0(builder: FlatBufferBuilder, b64Offset: Int, uriOffset: Int) : Int {
            builder.startTable(2)
            addUri(builder, uriOffset)
            addB64(builder, b64Offset)
            return endAnonymous0(builder)
        }
        fun startAnonymous0(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addB64(builder: FlatBufferBuilder, b64: Int) = builder.addOffset(0, b64, 0)
        fun addUri(builder: FlatBufferBuilder, uri: Int) = builder.addOffset(1, uri, 0)
        fun endAnonymous0(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
