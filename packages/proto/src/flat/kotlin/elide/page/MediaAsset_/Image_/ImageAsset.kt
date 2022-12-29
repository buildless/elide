// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.MediaAsset_.Image_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class ImageAsset : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ImageAsset {
        __init(_i, _bb)
        return this
    }
    val resolution : Float
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val mime : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val mimeAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun mimeInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val width : ULong
        get() {
            val o = __offset(8)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val height : ULong
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getLong(o + bb_pos).toULong() else 0UL
        }
    val content : elide.page.MediaAsset_.Image_.ImageAsset_.Anonymous0? get() = content(elide.page.MediaAsset_.Image_.ImageAsset_.Anonymous0())
    fun content(obj: elide.page.MediaAsset_.Image_.ImageAsset_.Anonymous0) : elide.page.MediaAsset_.Image_.ImageAsset_.Anonymous0? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsImageAsset(_bb: ByteBuffer): ImageAsset = getRootAsImageAsset(_bb, ImageAsset())
        fun getRootAsImageAsset(_bb: ByteBuffer, obj: ImageAsset): ImageAsset {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createImageAsset(builder: FlatBufferBuilder, resolution: Float, mimeOffset: Int, width: ULong, height: ULong, contentOffset: Int) : Int {
            builder.startTable(5)
            addHeight(builder, height)
            addWidth(builder, width)
            addContent(builder, contentOffset)
            addMime(builder, mimeOffset)
            addResolution(builder, resolution)
            return endImageAsset(builder)
        }
        fun startImageAsset(builder: FlatBufferBuilder) = builder.startTable(5)
        fun addResolution(builder: FlatBufferBuilder, resolution: Float) = builder.addFloat(0, resolution, 0.0)
        fun addMime(builder: FlatBufferBuilder, mime: Int) = builder.addOffset(1, mime, 0)
        fun addWidth(builder: FlatBufferBuilder, width: ULong) = builder.addLong(2, width.toLong(), 0)
        fun addHeight(builder: FlatBufferBuilder, height: ULong) = builder.addLong(3, height.toLong(), 0)
        fun addContent(builder: FlatBufferBuilder, content: Int) = builder.addOffset(4, content, 0)
        fun endImageAsset(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
