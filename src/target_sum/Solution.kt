package target_sum

import kotlin.math.abs

class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val m = nums.size
        val n = maxOf(nums.sum(), abs(target)) + 1
        val sols = Array(m) { IntArray(n) { 0 } }
        sols[0][nums[0]] = if (nums[0] == 0) 2 else 1
        for (i in 1 until m) {
            for (t in 0 until n) {
                sols[i][t] += sols[i - 1][abs(t - nums[i])]
                sols[i][t] += if (t + nums[i] < n) sols[i - 1][t + nums[i]] else 0
            }
        }
        return sols[m - 1][abs(target)]
    }
}

fun main() {
    val sol = Solution()
    println(sol.findTargetSumWays(intArrayOf(1,1,1,1,1), 3))
    println(sol.findTargetSumWays(intArrayOf(1,2,3,4), 3))
    println(sol.findTargetSumWays(intArrayOf(1,2,3,4), 4))
    println(sol.findTargetSumWays(intArrayOf(1000), -1000))
    println(sol.findTargetSumWays(intArrayOf(500,0,0,250,250), -500))
    println(sol.findTargetSumWays(intArrayOf(0), 0))
    println(sol.findTargetSumWays(intArrayOf(0,0), 0))
    println(sol.findTargetSumWays(intArrayOf(1,0,0), 1))
    println(sol.findTargetSumWays(intArrayOf(9,7,0,3,9,8,6,5,7,6), 2)) // 40
    println(sol.findTargetSumWays(intArrayOf(1), 2))
    println(sol.findTargetSumWays(intArrayOf(1,1,1,1), -1000))
}