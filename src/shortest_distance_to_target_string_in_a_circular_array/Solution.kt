package shortest_distance_to_target_string_in_a_circular_array

class Solution {
    fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
        val n = words.size
        for (l in 0 until n / 2 + 1) {
            val prev = words[Math.floorMod(startIndex - l, n)]
            val next = words[Math.floorMod(startIndex + l, n)]
            if (target == prev || target == next) return l
        }
        return -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.closestTarget(arrayOf("hello","i","am","leetcode","hello"), "hello", 1))
    println(sol.closestTarget(arrayOf("a","b","leetcode"), "leetcode", 0))
    println(sol.closestTarget(arrayOf("i","eat","leetcode"), "ate", 0))
}