// automatically generated by the FlatBuffers compiler, do not modify

package elide.page.Context_

@Suppress("unused")
class ReferrerPolicy private constructor() {
    companion object {
        const val DEFAULTREFERRERPOLICY: Int = 0
        const val NOREFERRER: Int = 1
        const val NOREFERRERWHENDOWNGRADE: Int = 2
        const val ORIGIN: Int = 3
        const val ORIGINWHENCROSSORIGIN: Int = 4
        const val SAME: Int = 5
        const val STRICTORIGIN: Int = 7
        const val STRICTORIGINWHENCROSSORIGIN: Int = 8
        const val UNSAFEURL: Int = 9
        val names : Array<String> = arrayOf("DEFAULT_REFERRER_POLICY", "NO_REFERRER", "NO_REFERRER_WHEN_DOWNGRADE", "ORIGIN", "ORIGIN_WHEN_CROSS_ORIGIN", "SAME", "", "STRICT_ORIGIN", "STRICT_ORIGIN_WHEN_CROSS_ORIGIN", "UNSAFE_URL")
        fun name(e: Int) : String = names[e]
    }
}
