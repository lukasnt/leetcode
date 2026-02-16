package find_the_difference

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var result = 0
        for (c in s + t) result = result xor c.code
        return result.toChar()
    }
}

fun main() {
    val sol = Solution()
    println(sol.findTheDifference("abcd", "abcde"))
    println(sol.findTheDifference("", "y"))
}