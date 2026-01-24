package reverse_words_in_a_string

class Solution {
    fun reverseWords(s: String): String {
        return s.trim().split(" ")
            .map { it.trim() }
            .filter { !it.isEmpty() }
            .reversed()
            .joinToString(" ")
    }
}

fun main() {
    val sol = Solution()
    println(sol.reverseWords("the sky is blue"))
    println(sol.reverseWords("  the   sky is   blue"))
    println(sol.reverseWords("a good   example"))
    println(sol.reverseWords(" s  "))
    println(sol.reverseWords("   "))
    println(sol.reverseWords("a"))
}