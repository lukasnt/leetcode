package missing_number

class Solution {
    fun missingNumber(nums: IntArray): Int {
        return nums.size * (nums.size + 1) / 2 - nums.sum()
    }
}

fun main() {
    val sol = Solution()
    println(sol.missingNumber(intArrayOf(3,0,1)))
    println(sol.missingNumber(intArrayOf(0,1)))
    println(sol.missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))
}