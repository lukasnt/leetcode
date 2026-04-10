package minimum_distance_between_three_equal_elements

class Solution {
    fun minimumDistance(nums: IntArray): Int {
        val singles = IntArray(nums.size) { -1 }
        val doubles = IntArray(nums.size) { -1 }
        var minDistance = Int.MAX_VALUE
        for (i in nums.indices) {
            val num = nums[i]
            if (doubles[num - 1] >= 0) {
                minDistance = minOf(minDistance, 2 * (i - doubles[num - 1]))
            }
            if (singles[num - 1] >= 0) {
                doubles[num - 1] = singles[num - 1]
            }
            singles[num - 1] = i
        }
        return if (minDistance != Int.MAX_VALUE) minDistance else -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.minimumDistance(intArrayOf(1,2,1,1,3)))
    println(sol.minimumDistance(intArrayOf(1,1,2,3,2,1,2)))
    println(sol.minimumDistance(intArrayOf(1)))
}