package minimum_moves_to_equal_array_elements_2

class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        val mid = n / 2
        val odd = n % 2
        return nums.sliceArray((mid + odd)..<n).sum() - nums.sliceArray(0..<mid).sum()
    }
}

fun main() {
    val sol = Solution()
    println(sol.minMoves2(intArrayOf(1,2,3)))
    println(sol.minMoves2(intArrayOf(1,10,2,9)))
    println(sol.minMoves2(intArrayOf(1,10,2,9,123)))
    println(sol.minMoves2(intArrayOf(1,1,1)))
}