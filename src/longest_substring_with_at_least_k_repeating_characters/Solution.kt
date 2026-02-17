package longest_substring_with_at_least_k_repeating_characters

class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        if (s.length < k) return 0
        val counts = Array(26) { 0 }
        for (i in 0 until s.length) {
            counts[s[i] - 'a']++
        }
        val invalid = HashSet<Char>()
        for (c in 0 until counts.size) {
            if (counts[c] in 1..<k) invalid.add('a' + c)
            counts[c] = 0
        }
        if (invalid.isEmpty()) return s.length
        var result = 0
        val sub = StringBuilder()
        for (c in s) {
            if (c !in invalid) {
                sub.append(c)
            } else {
                result = maxOf(result, longestSubstring(sub.toString(), k))
                sub.clear()
            }
        }
        return maxOf(result, longestSubstring(sub.toString(), k))
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestSubstring("aaabb", 3))
    println(sol.longestSubstring("ababbc", 2))
    println(sol.longestSubstring("ababbc", 3))
    println(sol.longestSubstring("bbaaacbd", 3))
    println(sol.longestSubstring("aabbaa", 3))
    println(sol.longestSubstring("aaa", 3))
    println(sol.longestSubstring("aa", 3))
}