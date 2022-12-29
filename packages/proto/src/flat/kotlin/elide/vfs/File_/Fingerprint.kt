// automatically generated by the FlatBuffers compiler, do not modify

package elide.vfs.File_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class Fingerprint : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Fingerprint {
        __init(_i, _bb)
        return this
    }
    val fingerprint : elide.vfs.File_.Fingerprint_.Anonymous0? get() = fingerprint(elide.vfs.File_.Fingerprint_.Anonymous0())
    fun fingerprint(obj: elide.vfs.File_.Fingerprint_.Anonymous0) : elide.vfs.File_.Fingerprint_.Anonymous0? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val algorithm : Int
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsFingerprint(_bb: ByteBuffer): Fingerprint = getRootAsFingerprint(_bb, Fingerprint())
        fun getRootAsFingerprint(_bb: ByteBuffer, obj: Fingerprint): Fingerprint {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFingerprint(builder: FlatBufferBuilder, fingerprintOffset: Int, algorithm: Int) : Int {
            builder.startTable(2)
            addAlgorithm(builder, algorithm)
            addFingerprint(builder, fingerprintOffset)
            return endFingerprint(builder)
        }
        fun startFingerprint(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addFingerprint(builder: FlatBufferBuilder, fingerprint: Int) = builder.addOffset(0, fingerprint, 0)
        fun addAlgorithm(builder: FlatBufferBuilder, algorithm: Int) = builder.addInt(1, algorithm, 0)
        fun endFingerprint(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
