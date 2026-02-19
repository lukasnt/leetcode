package kth_smallest_element_in_a_sorted_matrix

import java.util.PriorityQueue

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        val queue = PriorityQueue<IntArray>(Comparator.comparing { it[0] })
        val rowPos = IntArray(m) { -1 }
        val colPos = IntArray(n) { -1 }
        queue.add(intArrayOf(matrix[0][0], 0, 0))
        var i = 1
        while (i < k) {
            val last = queue.poll()
            if (last[1] < m - 1 && rowPos[last[1] + 1] < last[2]) {
                colPos[last[2]] = last[1] + 1
                queue.add(intArrayOf(matrix[last[1] + 1][last[2]], last[1] + 1, last[2]))
            }
            if (last[2] < n - 1 && colPos[last[2] + 1] < last[1]) {
                rowPos[last[1]] = last[2] + 1
                queue.add(intArrayOf(matrix[last[1]][last[2] + 1], last[1], last[2] + 1))
            }
            i++
        }
        return queue.poll()[0]
    }
}

fun main() {
    val sol = Solution()
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,9),
        intArrayOf(10,11,13),
        intArrayOf(12,13,15)
    ), 8))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,9),
        intArrayOf(10,11,13),
        intArrayOf(12,13,15)
    ), 2))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,9),
        intArrayOf(10,11,13),
        intArrayOf(12,14,15)
    ), 9))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,13),
        intArrayOf(10,13,13),
        intArrayOf(13,14,15)
    ), 8))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,13)
    ), 2))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,13)
    ), 1))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1,5,13)
    ), 3))
    println(sol.kthSmallest(arrayOf(
        intArrayOf(1),
        intArrayOf(5),
        intArrayOf(13)
    ), 2))
}