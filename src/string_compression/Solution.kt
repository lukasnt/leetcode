package string_compression

class Solution {
    fun compress(chars: CharArray): Int {
        var current = chars[0]
        var count = 1
        var end = 0
        for (i in 1 until chars.size) {
            if (chars[i] != current) {
                chars[end++] = current
                if (count > 1) {
                    val countString = count.toString()
                    for (j in 0 until countString.length) {
                        chars[end++] = countString[j]
                    }
                }
                current = chars[i]
                count = 1
            } else {
                count++
            }
        }
        chars[end++] = current
        if (count > 1) {
            val countString = count.toString()
            for (j in 0 until countString.length) {
                chars[end++] = countString[j]
            }
        }
        return end
    }
}

fun main() {
    val sol = Solution()
    println(sol.compress(charArrayOf('a','a','b','b','c','c','c')))
    println(sol.compress(charArrayOf('a')))
    println(sol.compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')))
    println(sol.compress(charArrayOf('a','a','b','b','c')))
}