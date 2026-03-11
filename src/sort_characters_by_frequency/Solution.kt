package sort_characters_by_frequency

class Solution {
    fun frequencySort(s: String): String {
        val count = IntArray('z' - '0' + 1) { 0 }
        for (c in s) {
            count[c - '0']++
        }
        val result = StringBuilder(s.length)
        count.withIndex()
            .sortedByDescending { it.value }
            .forEach { result.append(('0' + it.index).toString().repeat(it.value)) }
        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.frequencySort("tree"))
    println(sol.frequencySort("cccaaa"))
    println(sol.frequencySort("Aabb"))
    println(sol.frequencySort("AabbZZzzz"))
    println(sol.frequencySort("82348723848273648732647367436"))
}