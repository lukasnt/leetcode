package continuous_subarray_sum

class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val sumMods = HashMap<Int, Boolean>()
        var sum = 0
        for (num in nums) {
            if (sumMods[(sum + num) % k] ?: false) return true
            sumMods[sum % k] = true
            sum += num
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.checkSubarraySum(intArrayOf(23,2,4,6,7), 6))
    println(sol.checkSubarraySum(intArrayOf(23,2,6,4,7), 6))
    println(sol.checkSubarraySum(intArrayOf(23,2,6,4,7), 13))
}