// automatically generated by the FlatBuffers compiler, do not modify

package elide.vfs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class BundleArtifacts : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : BundleArtifacts {
        __init(_i, _bb)
        return this
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsBundleArtifacts(_bb: ByteBuffer): BundleArtifacts = getRootAsBundleArtifacts(_bb, BundleArtifacts())
        fun getRootAsBundleArtifacts(_bb: ByteBuffer, obj: BundleArtifacts): BundleArtifacts {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun startBundleArtifacts(builder: FlatBufferBuilder) = builder.startTable(0)
        fun endBundleArtifacts(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
