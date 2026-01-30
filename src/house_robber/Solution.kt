package house_robber

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size <= 2) return nums.max()
        val sol = IntArray(nums.size) { 0 }
        sol[nums.size - 1] = nums[nums.size - 1]
        sol[nums.size - 2] = maxOf(nums[nums.size - 2], nums[nums.size - 1])
        for (i in nums.size - 3 downTo 0) {
            sol[i] = maxOf(nums[i] + sol[i + 2], sol[i + 1])
        }
        return sol[0]
    }
}

fun main() {
    val sol = Solution()
    println(sol.rob(intArrayOf(1,2,3,1)))
    println(sol.rob(intArrayOf(2,7,9,3,1)))
    println(sol.rob(intArrayOf(19,20,7,9,3,1)))
    println(sol.rob(intArrayOf(19,20,7,9,3,1,2)))
    println(sol.rob(intArrayOf(10)))
    println(sol.rob(intArrayOf(10,2)))
    println(sol.rob(intArrayOf(9,10,2)))
    println(sol.rob(intArrayOf(7,10,2)))
}