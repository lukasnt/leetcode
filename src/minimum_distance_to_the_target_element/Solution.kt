package minimum_distance_to_the_target_element

class Solution {
    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        for (i in 0 until maxOf(start + 1, nums.size - start)) {
            val right = (start + i).let { it < nums.size && nums[it] == target }
            val left  = (start - i).let { it >= 0        && nums[it] == target }
            if (left || right) return i
        }
        return -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.getMinDistance(intArrayOf(1,2,3,4,5), 5, 3))
    println(sol.getMinDistance(intArrayOf(1), 1, 0))
    println(sol.getMinDistance(intArrayOf(1,1,1,1,1,1,1,1,1,1), 1, 0))
    println(sol.getMinDistance(intArrayOf(1,2,3,4,5), 1, 4))
    println(sol.getMinDistance(intArrayOf(1,2,3,4,5), 5, 0))
    println(sol.getMinDistance(intArrayOf(1,2,3,4,5), 5, 1))
}