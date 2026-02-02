package minimum_size_subarray_sum

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var i = 0
        var j = 0
        var subSum = 0
        var result = 0
        while (i < nums.size || j < nums.size || subSum > target) {
            if (subSum < target && j < nums.size) {
                subSum += nums[j]
                j++
            } else {
                i++
                subSum -= nums[i - 1]
            }
            if (subSum >= target && (j - i < result || result == 0)) {
                result = j - i
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
    println(sol.minSubArrayLen(4, intArrayOf(1,4,4)))
    println(sol.minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1,1,1)))
    println(sol.minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1,1,1,1)))
    println(sol.minSubArrayLen(11, intArrayOf(11)))
    println(sol.minSubArrayLen(11, intArrayOf(8,4)))
}