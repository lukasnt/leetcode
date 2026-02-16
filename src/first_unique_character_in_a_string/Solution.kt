package first_unique_character_in_a_string

class Solution {
    fun firstUniqChar(s: String): Int {
        val count = HashMap<Char, Int>()
        for (c in s) {
            count[c] = count.getOrDefault(c, 0) + 1
        }
        for (i in 0 until s.length) {
            if (count[s[i]] == 1) return i
        }
        return -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.firstUniqChar("leetcode"))
    println(sol.firstUniqChar("loveleetcode"))
    println(sol.firstUniqChar("aabb"))
}