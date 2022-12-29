// automatically generated by the FlatBuffers compiler, do not modify

package elide.assets.AssetBundle_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class BundlerSettings : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : BundlerSettings {
        __init(_i, _bb)
        return this
    }
    val minify : Boolean
        get() {
            val o = __offset(4)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val prepack : Boolean
        get() {
            val o = __offset(6)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val rewriting : Boolean
        get() {
            val o = __offset(8)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    fun compression(j: Int) : Int {
        val o = __offset(10)
        return if (o != 0) {
            bb.getInt(__vector(o) + j * 4)
        } else {
            0
        }
    }
    val compressionLength : Int
        get() {
            val o = __offset(10); return if (o != 0) __vector_len(o) else 0
        }
    val compressionAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(10, 4)
    fun compressionInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 10, 4)
    val digestSettings : elide.assets.AssetBundle_.DigestSettings? get() = digestSettings(elide.assets.AssetBundle_.DigestSettings())
    fun digestSettings(obj: elide.assets.AssetBundle_.DigestSettings) : elide.assets.AssetBundle_.DigestSettings? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsBundlerSettings(_bb: ByteBuffer): BundlerSettings = getRootAsBundlerSettings(_bb, BundlerSettings())
        fun getRootAsBundlerSettings(_bb: ByteBuffer, obj: BundlerSettings): BundlerSettings {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createBundlerSettings(builder: FlatBufferBuilder, minify: Boolean, prepack: Boolean, rewriting: Boolean, compressionOffset: Int, digestSettingsOffset: Int) : Int {
            builder.startTable(5)
            addDigestSettings(builder, digestSettingsOffset)
            addCompression(builder, compressionOffset)
            addRewriting(builder, rewriting)
            addPrepack(builder, prepack)
            addMinify(builder, minify)
            return endBundlerSettings(builder)
        }
        fun startBundlerSettings(builder: FlatBufferBuilder) = builder.startTable(5)
        fun addMinify(builder: FlatBufferBuilder, minify: Boolean) = builder.addBoolean(0, minify, false)
        fun addPrepack(builder: FlatBufferBuilder, prepack: Boolean) = builder.addBoolean(1, prepack, false)
        fun addRewriting(builder: FlatBufferBuilder, rewriting: Boolean) = builder.addBoolean(2, rewriting, false)
        fun addCompression(builder: FlatBufferBuilder, compression: Int) = builder.addOffset(3, compression, 0)
        fun createCompressionVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addInt(data[i])
            }
            return builder.endVector()
        }
        fun startCompressionVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addDigestSettings(builder: FlatBufferBuilder, digestSettings: Int) = builder.addOffset(4, digestSettings, 0)
        fun endBundlerSettings(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
