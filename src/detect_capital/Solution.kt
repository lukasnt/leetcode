package detect_capital

class Solution {
    fun detectCapitalUse(word: String): Boolean {
        var upper = word[0].isUpperCase()
        var lower = word[0].isLowerCase()
        var first = word[0].isUpperCase()
        for (i in 1 until word.length) {
            val c = word[i]
            upper = upper && c.isUpperCase()
            lower = lower && c.isLowerCase()
            first = first && c.isLowerCase()
        }
        return upper || lower || first
    }
}

fun main() {
    val sol = Solution()
    println(sol.detectCapitalUse("USA"))
    println(sol.detectCapitalUse("FlaG"))
    println(sol.detectCapitalUse("Google"))
    println(sol.detectCapitalUse("G"))
    println(sol.detectCapitalUse("leetcode"))
    println(sol.detectCapitalUse("l"))
}