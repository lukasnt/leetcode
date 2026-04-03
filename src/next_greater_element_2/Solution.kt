package next_greater_element_2

import java.util.*

class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n) { -1 }
        val remaining = PriorityQueue<Pair<Int, Int>>(
            Comparator.comparingInt { it.second }
        )
        for (i in 0 until 2 * n) {
            val index = i % n
            if (result[index] == -1) {
                remaining.add(index to nums[index])
            }
            while (nums[index] > remaining.first().second) {
                result[remaining.poll().first] = nums[index]
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.nextGreaterElements(intArrayOf(1,2,1)).contentToString())
    println(sol.nextGreaterElements(intArrayOf(1,2,3,4,3)).contentToString())
    println(sol.nextGreaterElements(intArrayOf(1,2,3,2,1)).contentToString())
    println(sol.nextGreaterElements(intArrayOf(1,2,2)).contentToString())
    println(sol.nextGreaterElements(intArrayOf(5,4,3,2,1)).contentToString())
}