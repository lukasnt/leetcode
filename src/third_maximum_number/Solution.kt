package third_maximum_number

import java.util.*

class Solution {
    fun thirdMax(nums: IntArray): Int {
        val maximums = PriorityQueue<Int>()
        for (num in nums.toSet()) {
            if (maximums.size < 3) {
                maximums.add(num)
            } else if (num > maximums.peek()) {
                maximums.add(num)
                maximums.poll()
            }
        }
        return if (maximums.size == 3) maximums.peek() else maximums.max()
    }
}

fun main() {
    val sol = Solution()
    println(sol.thirdMax(intArrayOf(3, 2, 1)))
    println(sol.thirdMax(intArrayOf(1, 2)))
    println(sol.thirdMax(intArrayOf(2, 2, 3, 1)))
}