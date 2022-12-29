// automatically generated by the FlatBuffers compiler, do not modify

package elide.vfs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class TreeEntry : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : TreeEntry {
        __init(_i, _bb)
        return this
    }
    val parent : elide.vfs.TreeEntry? get() = parent(elide.vfs.TreeEntry())
    fun parent(obj: elide.vfs.TreeEntry) : elide.vfs.TreeEntry? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val entry : elide.vfs.TreeEntry_.Anonymous2? get() = entry(elide.vfs.TreeEntry_.Anonymous2())
    fun entry(obj: elide.vfs.TreeEntry_.Anonymous2) : elide.vfs.TreeEntry_.Anonymous2? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsTreeEntry(_bb: ByteBuffer): TreeEntry = getRootAsTreeEntry(_bb, TreeEntry())
        fun getRootAsTreeEntry(_bb: ByteBuffer, obj: TreeEntry): TreeEntry {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createTreeEntry(builder: FlatBufferBuilder, parentOffset: Int, entryOffset: Int) : Int {
            builder.startTable(2)
            addEntry(builder, entryOffset)
            addParent(builder, parentOffset)
            return endTreeEntry(builder)
        }
        fun startTreeEntry(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addParent(builder: FlatBufferBuilder, parent: Int) = builder.addOffset(0, parent, 0)
        fun addEntry(builder: FlatBufferBuilder, entry: Int) = builder.addOffset(1, entry, 0)
        fun endTreeEntry(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
