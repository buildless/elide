// automatically generated by the FlatBuffers compiler, do not modify

package elide.data

@Suppress("unused")
class Encoding private constructor() {
    companion object {
        const val UTF8: Int = 0
        const val UTF16: Int = 1
        const val UTF32: Int = 2
        val names : Array<String> = arrayOf("UTF_8", "UTF_16", "UTF_32")
        fun name(e: Int) : String = names[e]
    }
}
