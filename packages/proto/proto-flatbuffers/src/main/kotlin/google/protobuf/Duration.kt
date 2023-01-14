// automatically generated by the FlatBuffers compiler, do not modify

package google.protobuf

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class Duration : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Duration {
        __init(_i, _bb)
        return this
    }
    val seconds : Long
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getLong(o + bb_pos) else 0L
        }
    val nanos : Int
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsDuration(_bb: ByteBuffer): Duration = getRootAsDuration(_bb, Duration())
        fun getRootAsDuration(_bb: ByteBuffer, obj: Duration): Duration {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createDuration(builder: FlatBufferBuilder, seconds: Long, nanos: Int) : Int {
            builder.startTable(2)
            addSeconds(builder, seconds)
            addNanos(builder, nanos)
            return endDuration(builder)
        }
        fun startDuration(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addSeconds(builder: FlatBufferBuilder, seconds: Long) = builder.addLong(0, seconds, 0L)
        fun addNanos(builder: FlatBufferBuilder, nanos: Int) = builder.addInt(1, nanos, 0)
        fun endDuration(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
