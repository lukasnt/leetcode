package decode_string

class Solution {
    fun decodeString(s: String): String {
        val encoded = ArrayDeque<StringBuilder>()
        val repeats = ArrayDeque<Int>()
        val num = StringBuilder()
        var current = StringBuilder()
        for (c in s) {
            if (c.isDigit()) {
                num.append(c)
            } else {
                if (num.isNotEmpty()) {
                    repeats.add(num.toString().toInt())
                    num.clear()
                }
                when (c) {
                    '[' -> {
                        encoded.add(current)
                        current = StringBuilder()
                    }
                    ']' -> {
                        val repeat = repeats.removeLast()
                        val last = encoded.removeLast()
                        current = last.append(current.repeat(repeat))
                    }
                    else -> current.append(c)
                }
            }
        }
        return current.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.decodeString("3[a]2[bc]"))
    println(sol.decodeString("3[a2[c]]"))
    println(sol.decodeString("2[abc]3[cd]ef"))
    println(sol.decodeString("abc"))
    println(sol.decodeString("100[leetcode]"))
}