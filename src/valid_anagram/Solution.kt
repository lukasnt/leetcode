package valid_anagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sCount: MutableMap<Char, Int> = HashMap()
        val tCount: MutableMap<Char, Int> = HashMap()
        for (c in s) {
            sCount[c] = sCount.getOrDefault(c, 0) + 1
        }
        for (c in t) {
            tCount[c] = tCount.getOrDefault(c, 0) + 1
        }
        for (c in sCount.keys.union(tCount.keys)) {
            if (sCount[c] != tCount[c]) return false
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.isAnagram("anagram", "nagaram"))
    println(sol.isAnagram("anagram", "nagarams"))
    println(sol.isAnagram("anagrams", "nagarama"))
    println(sol.isAnagram("rat", "car"))
    println(sol.isAnagram("", ""))
    println(sol.isAnagram("a", "a"))
    println(sol.isAnagram("a", ""))
}