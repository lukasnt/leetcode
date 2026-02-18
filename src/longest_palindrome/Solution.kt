package longest_palindrome

class Solution {
    fun longestPalindrome(s: String): Int {
        val counts = HashMap<Char, Int>()
        for (c in s) {
            counts[c] = counts.getOrDefault(c, 0) + 1
        }
        return counts.values.sumOf { it - it % 2 } + if (counts.values.any { it % 2 == 1 }) 1 else 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestPalindrome("abccccdd"))
    println(sol.longestPalindrome("a"))
    println(sol.longestPalindrome("ab"))
    println(sol.longestPalindrome("abb"))
    println(sol.longestPalindrome("abba"))
    println(sol.longestPalindrome("Abba"))
}