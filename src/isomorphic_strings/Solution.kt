package isomorphic_strings

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = HashMap<Char, Char>()
        for (i in 0 until s.length) {
            if (map[s[i]] == null && !map.values.contains(t[i])) {
                map[s[i]] = t[i]
            } else if (map[s[i]] != t[i]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.isIsomorphic("egg", "add"))
    println(sol.isIsomorphic("f11", "b23"))
    println(sol.isIsomorphic("paper", "title"))
    println(sol.isIsomorphic("f", "b"))
    println(sol.isIsomorphic("f", "b2"))
    println(sol.isIsomorphic("paper", "apare"))
    println(sol.isIsomorphic("badc", "baba"))
}