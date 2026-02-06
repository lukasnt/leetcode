package move_zeroes

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroes = 0
        for (i in 0 until nums.size) {
            if (nums[i] == 0) zeroes++
            else nums[i - zeroes] = nums[i]
        }
        for (i in nums.size - zeroes until nums.size) {
            nums[i] = 0
        }
    }

    fun solvePrint(nums: IntArray) {
        moveZeroes(nums)
        println(nums.contentToString())
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrint(intArrayOf(0,1,0,3,12))
    sol.solvePrint(intArrayOf(0))
    sol.solvePrint(intArrayOf(0,1,4,0,0,3,0,12,0))
    sol.solvePrint(intArrayOf(1))
    sol.solvePrint(intArrayOf(1,0))
}