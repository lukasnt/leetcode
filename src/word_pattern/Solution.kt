package word_pattern

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (pattern.length != words.size) return false
        val wordMap: MutableMap<Char, String> = HashMap()
        for (i in 0 until pattern.length) {
            if (wordMap[pattern[i]] == null && words[i] !in wordMap.values) {
                wordMap[pattern[i]] = words[i]
            } else if (wordMap[pattern[i]] != words[i]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.wordPattern("abba", "dog cat cat dog"))
    println(sol.wordPattern("abba", "dog cat cat fish"))
    println(sol.wordPattern("aaaa", "dog cat cat dog"))
    println(sol.wordPattern("aaaa", "dog dog dog dog"))
    println(sol.wordPattern("abba", "dog dog dog dog"))
}