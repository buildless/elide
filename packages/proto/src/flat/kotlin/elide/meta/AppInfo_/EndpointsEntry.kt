// automatically generated by the FlatBuffers compiler, do not modify

package elide.meta.AppInfo_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class EndpointsEntry : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : EndpointsEntry {
        __init(_i, _bb)
        return this
    }
    val key : String?
        get() {
            val o = __offset(4)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val keyAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(4, 1)
    fun keyInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 4, 1)
    val value : elide.meta.Endpoint? get() = value(elide.meta.Endpoint())
    fun value(obj: elide.meta.Endpoint) : elide.meta.Endpoint? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    override fun keysCompare(o1: Int, o2: Int, _bb: ByteBuffer) : Int {
         return compareStrings(__offset(4, o1, _bb), __offset(4, o2, _bb), _bb)
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsEndpointsEntry(_bb: ByteBuffer): EndpointsEntry = getRootAsEndpointsEntry(_bb, EndpointsEntry())
        fun getRootAsEndpointsEntry(_bb: ByteBuffer, obj: EndpointsEntry): EndpointsEntry {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createEndpointsEntry(builder: FlatBufferBuilder, keyOffset: Int, valueOffset: Int) : Int {
            builder.startTable(2)
            addValue(builder, valueOffset)
            addKey(builder, keyOffset)
            return endEndpointsEntry(builder)
        }
        fun startEndpointsEntry(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addKey(builder: FlatBufferBuilder, key: Int)  {
            builder.addOffset(key)
            builder.slot(0)
        }
        fun addValue(builder: FlatBufferBuilder, value: Int) = builder.addOffset(1, value, 0)
        fun endEndpointsEntry(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
                builder.required(o, 4)
            return o
        }
        fun __lookup_by_key(obj: EndpointsEntry?, vectorLocation: Int, key: String, bb: ByteBuffer) : EndpointsEntry? {
            val byteKey = key.toByteArray(java.nio.charset.StandardCharsets.UTF_8)
            var span = bb.getInt(vectorLocation - 4)
            var start = 0
            while (span != 0) {
                var middle = span / 2
                val tableOffset = __indirect(vectorLocation + 4 * (start + middle), bb)
                val comp = compareStrings(__offset(4, bb.capacity() - tableOffset, bb), byteKey, bb)
                when {
                    comp > 0 -> span = middle
                    comp < 0 -> {
                        middle++
                        start += middle
                        span -= middle
                    }
                    else -> {
                        return (obj ?: EndpointsEntry()).__assign(tableOffset, bb)
                    }
                }
            }
            return null
        }
    }
}
