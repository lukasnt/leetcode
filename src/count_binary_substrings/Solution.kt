package count_binary_substrings

class Solution {
    fun countBinarySubstrings(s: String): Int {
        var last = 0
        var count = 0
        var result = 0
        var current = s[0]
        for (i in 0 until s.length) {
            if (s[i] != current) {
                last = count
                count = 0
                current = s[i]
            }
            count++
            if (count <= last) result++
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.countBinarySubstrings("00110011"))
    println(sol.countBinarySubstrings("10101"))
    println(sol.countBinarySubstrings("1001101"))
    println(sol.countBinarySubstrings("1"))
    println(sol.countBinarySubstrings("0"))
    println(sol.countBinarySubstrings("00"))
    println(sol.countBinarySubstrings("11"))
    println(sol.countBinarySubstrings("10"))
    println(sol.countBinarySubstrings("01"))
}