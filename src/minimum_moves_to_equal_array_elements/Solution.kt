package minimum_moves_to_equal_array_elements

class Solution {
    fun minMoves(nums: IntArray): Int {
        nums.sort()
        var result = 0
        var prev = 0
        for (i in 1 until nums.size) {
            val diff = nums[i] - nums[i - 1]
            result += prev + diff
            prev += diff
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.minMoves(intArrayOf(1,2,3)))
    println(sol.minMoves(intArrayOf(1,2,3,4)))
    println(sol.minMoves(intArrayOf(1,2,3,4,5)))
    println(sol.minMoves(intArrayOf(1,2,3,5)))
    println(sol.minMoves(intArrayOf(3,5,1,2)))
}