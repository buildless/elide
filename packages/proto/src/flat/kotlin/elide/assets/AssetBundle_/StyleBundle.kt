// automatically generated by the FlatBuffers compiler, do not modify

package elide.assets.AssetBundle_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class StyleBundle : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : StyleBundle {
        __init(_i, _bb)
        return this
    }
    val module : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val moduleAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun moduleInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val rewriteMap : elide.assets.AssetBundle_.RewriteMap? get() = rewriteMap(elide.assets.AssetBundle_.RewriteMap())
    fun rewriteMap(obj: elide.assets.AssetBundle_.RewriteMap) : elide.assets.AssetBundle_.RewriteMap? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val dependencies : elide.assets.AssetBundle_.AssetDependencies? get() = dependencies(elide.assets.AssetBundle_.AssetDependencies())
    fun dependencies(obj: elide.assets.AssetBundle_.AssetDependencies) : elide.assets.AssetBundle_.AssetDependencies? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    fun asset(j: Int) : elide.assets.AssetBundle_.StyleBundle_.StyleAsset? = asset(elide.assets.AssetBundle_.StyleBundle_.StyleAsset(), j)
    fun asset(obj: elide.assets.AssetBundle_.StyleBundle_.StyleAsset, j: Int) : elide.assets.AssetBundle_.StyleBundle_.StyleAsset? {
        val o = __offset(10)
        return if (o != 0) {
            obj.__assign(__indirect(__vector(o) + j * 4), bb)
        } else {
            null
        }
    }
    val assetLength : Int
        get() {
            val o = __offset(10); return if (o != 0) __vector_len(o) else 0
        }
    val compressable : Boolean
        get() {
            val o = __offset(12)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    val cacheable : Boolean
        get() {
            val o = __offset(14)
            return if(o != 0) 0.toByte() != bb.get(o + bb_pos) else false
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsStyleBundle(_bb: ByteBuffer): StyleBundle = getRootAsStyleBundle(_bb, StyleBundle())
        fun getRootAsStyleBundle(_bb: ByteBuffer, obj: StyleBundle): StyleBundle {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createStyleBundle(builder: FlatBufferBuilder, moduleOffset: Int, rewriteMapOffset: Int, dependenciesOffset: Int, assetOffset: Int, compressable: Boolean, cacheable: Boolean) : Int {
            builder.startTable(6)
            addAsset(builder, assetOffset)
            addDependencies(builder, dependenciesOffset)
            addRewriteMap(builder, rewriteMapOffset)
            addModule(builder, moduleOffset)
            addCacheable(builder, cacheable)
            addCompressable(builder, compressable)
            return endStyleBundle(builder)
        }
        fun startStyleBundle(builder: FlatBufferBuilder) = builder.startTable(6)
        fun addModule(builder: FlatBufferBuilder, module: Int) = builder.addOffset(0, module, 0)
        fun addRewriteMap(builder: FlatBufferBuilder, rewriteMap: Int) = builder.addOffset(1, rewriteMap, 0)
        fun addDependencies(builder: FlatBufferBuilder, dependencies: Int) = builder.addOffset(2, dependencies, 0)
        fun addAsset(builder: FlatBufferBuilder, asset: Int) = builder.addOffset(3, asset, 0)
        fun createAssetVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startAssetVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addCompressable(builder: FlatBufferBuilder, compressable: Boolean) = builder.addBoolean(4, compressable, false)
        fun addCacheable(builder: FlatBufferBuilder, cacheable: Boolean) = builder.addBoolean(5, cacheable, false)
        fun endStyleBundle(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
