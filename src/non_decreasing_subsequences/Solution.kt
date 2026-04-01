package non_decreasing_subsequences

import java.util.TreeMap

class Solution {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val subsequences = TreeMap<Int, MutableSet<List<Int>>>()
        for (num in nums) {
            val next = mutableSetOf(listOf(num))
            next.addAll(subsequences.headMap(num, true)
                .values.flatten()
                .map { seq -> seq.plus(num) }
            )
            subsequences.merge(num, next) { prev, values ->
                prev.addAll(values)
                prev
            }
        }
        return subsequences.values.flatten().filter { it.size > 1 }
    }
}

fun main() {
    val sol = Solution()
    println(sol.findSubsequences(intArrayOf(4,6,7,7)))
    println(sol.findSubsequences(intArrayOf(4,4,3,2,1)))
    println(sol.findSubsequences(intArrayOf(7,4,6,7)))
    println(sol.findSubsequences(intArrayOf(7,4,6,7,7)))
}