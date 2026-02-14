package kth_largest_element_in_an_array

import java.util.PriorityQueue

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val largest = PriorityQueue<Int>()
        for (num in nums) {
            largest.add(num)
            if (largest.size > k) {
                largest.poll()
            }
        }
        return largest.poll()
    }
}

fun main() {
    val sol = Solution()
    println(sol.findKthLargest(intArrayOf(3,2,1,5,6,4), 1))
    println(sol.findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
    println(sol.findKthLargest(intArrayOf(3,2,1,5,6,4), 3))
    println(sol.findKthLargest(intArrayOf(3,2,1,5,6,4), 4))
    println(sol.findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
}