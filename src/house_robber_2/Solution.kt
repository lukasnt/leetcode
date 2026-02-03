package house_robber_2

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])
        val n = nums.size
        val included = IntArray(n - 1) { 0 }
        val skipped = IntArray(n - 1) { 0 }
        included[0] = nums[0]
        included[1] = maxOf(nums[0], nums[1])
        skipped[0] = 0
        skipped[1] = nums[1]
        for (i in 2 until n - 1) {
            included[i] = maxOf(included[i - 1], nums[i] + included[i - 2])
            skipped[i] = maxOf(skipped[i - 1], nums[i] + skipped[i - 2])
        }
        return maxOf(nums[n - 1] + skipped[n - 3], included[n - 2])
    }
}

fun main() {
    val sol = Solution()
    println(sol.rob(intArrayOf(2,3,2)))
    println(sol.rob(intArrayOf(1,2,3,1)))
    println(sol.rob(intArrayOf(1,2,3)))
    println(sol.rob(intArrayOf(1,2)))
    println(sol.rob(intArrayOf(5,1,2,3,1)))
}