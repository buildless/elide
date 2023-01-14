// automatically generated by the FlatBuffers compiler, do not modify

package elide.vfs.TreeEntry_

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class TreeEntrySpec : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : TreeEntrySpec {
        __init(_i, _bb)
        return this
    }
    val directory : elide.vfs.Directory? get() = directory(elide.vfs.Directory())
    fun directory(obj: elide.vfs.Directory) : elide.vfs.Directory? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val file : elide.vfs.File? get() = file(elide.vfs.File())
    fun file(obj: elide.vfs.File) : elide.vfs.File? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_22_12_06()
        fun getRootAsTreeEntrySpec(_bb: ByteBuffer): TreeEntrySpec = getRootAsTreeEntrySpec(_bb, TreeEntrySpec())
        fun getRootAsTreeEntrySpec(_bb: ByteBuffer, obj: TreeEntrySpec): TreeEntrySpec {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createTreeEntrySpec(builder: FlatBufferBuilder, directoryOffset: Int, fileOffset: Int) : Int {
            builder.startTable(2)
            addFile(builder, fileOffset)
            addDirectory(builder, directoryOffset)
            return endTreeEntrySpec(builder)
        }
        fun startTreeEntrySpec(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addDirectory(builder: FlatBufferBuilder, directory: Int) = builder.addOffset(0, directory, 0)
        fun addFile(builder: FlatBufferBuilder, file: Int) = builder.addOffset(1, file, 0)
        fun endTreeEntrySpec(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
