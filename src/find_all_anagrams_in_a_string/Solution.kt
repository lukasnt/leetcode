package find_all_anagrams_in_a_string

class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) return emptyList()
        val counts = IntArray(26) { 0 }
        for (c in p) {
            counts[c - 'a']++
        }
        val window = IntArray(26) { 0 }
        val size = p.length
        for (k in 0 until size) {
            window[s[k] - 'a']++
        }
        val result = ArrayList<Int>()
        if (window.contentEquals(counts)) {
            result.add(0)
        }
        var i = 0
        var j = size
        while (j < s.length) {
            window[s[i++] - 'a']--
            window[s[j++] - 'a']++
            if (window.contentEquals(counts)) {
                result.add(i)
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findAnagrams("cbaebabacd", "abc"))
    println(sol.findAnagrams("abab", "ab"))
    println(sol.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"))
}