package find_k_pairs_with_smallest_sums

import java.util.PriorityQueue

class Solution {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val queue = PriorityQueue<Pair<Pair<Int, Int>, Int>>(Comparator.comparingInt { it.second })
        queue.add(Pair(Pair(0, 0), nums1[0] + nums2[0]))
        var l = 0
        while (l < k && queue.isNotEmpty()) {
            val last = queue.poll()
            val (i, j) = last.first
            result.add(listOf(nums1[i], nums2[j]))
            if (j == 0 && i < nums1.size - 1) {
                queue.add(Pair(Pair(i + 1, j), nums1[i + 1] + nums2[j]))
            }
            if (j < nums2.size - 1) {
                queue.add(Pair(Pair(i, j + 1), nums1[i] + nums2[j + 1]))
            }
            l++
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.kSmallestPairs(intArrayOf(1,7,11), intArrayOf(2,4,6), 3))
    println(sol.kSmallestPairs(intArrayOf(1,7,11), intArrayOf(2,4,6), 9))
    println(sol.kSmallestPairs(intArrayOf(1,1,2), intArrayOf(1,2,3), 2))
    println(sol.kSmallestPairs(intArrayOf(1,1,2), intArrayOf(1,2,3), 9))
    println(sol.kSmallestPairs(intArrayOf(2), intArrayOf(1), 1))
    println(sol.kSmallestPairs(intArrayOf(2,3), intArrayOf(1,2), 2))
}