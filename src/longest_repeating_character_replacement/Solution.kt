package longest_repeating_character_replacement

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var result = Int.MIN_VALUE
        for (c in 'A' until 'Z' + 1) {
            val replacements = ArrayDeque<Pair<Int, Int>>()
            var length = 0
            var repeating = 0
            for (i in 0 until s.length) {
                if (s[i] != c) {
                    replacements.add(i to repeating)
                    if (replacements.size > k) {
                        val first = replacements.removeFirst()
                        length -= first.second + 1
                    }
                    repeating = 0
                } else {
                    repeating++
                }
                length++
                if (length > result) {
                    result = length
                }
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.characterReplacement("ABAB", 2))
    println(sol.characterReplacement("ABAB", 1))
    println(sol.characterReplacement("AABABBA", 1))
    println(sol.characterReplacement("AABABBA", 2))
    println(sol.characterReplacement("AABABBA", 3))
    println(sol.characterReplacement("AAAAABBBAAADDAAACCAAAA", 4))
    println(sol.characterReplacement("ABA", 1))
    println(sol.characterReplacement("AAA", 1))
    println(sol.characterReplacement("A", 1))
}