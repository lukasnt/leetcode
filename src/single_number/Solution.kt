package single_number

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = result xor num
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.singleNumber(intArrayOf(2,2,1)))
    println(sol.singleNumber(intArrayOf(4,1,2,1,2)))
    println(sol.singleNumber(intArrayOf(3,1,3,2,2)))
    println(sol.singleNumber(intArrayOf(3,1,3,2,2,1,4)))
    println(sol.singleNumber(intArrayOf(1)))
    println(sol.singleNumber(intArrayOf(2)))
}