package maximum_non_negative_product_in_a_matrix

class Solution {
    fun maxProductPath(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val maxes = Array(m) { LongArray(n) { Long.MIN_VALUE } }
        val mins  = Array(m) { LongArray(n) { Long.MAX_VALUE } }
        maxes[0][0] = grid[0][0].toLong()
        mins [0][0] = grid[0][0].toLong()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 && j == 0) continue
                val cell = grid[i][j]
                if (cell >= 0) {
                    maxes[i][j] = maxOf(getMax(i - 1, j, maxes), getMax(i, j - 1, maxes)) * cell
                    mins [i][j] = minOf(getMin(i - 1, j, mins),  getMin(i, j - 1, mins))  * cell
                } else {
                    maxes[i][j] = minOf(getMin(i - 1, j, mins),  getMin(i, j - 1, mins))  * cell
                    mins [i][j] = maxOf(getMax(i - 1, j, maxes), getMax(i, j - 1, maxes)) * cell
                }
            }
        }
        val max = maxes[m - 1][n - 1]
        return if (max >= 0) (max % 1_000_000_007L).toInt() else -1
    }

    fun getMax(i: Int, j: Int, sols: Array<LongArray>): Long {
        return if (i in sols.indices && j in sols[i].indices) sols[i][j] else Long.MIN_VALUE
    }

    fun getMin(i: Int, j: Int, sols: Array<LongArray>): Long {
        return if (i in sols.indices && j in sols[i].indices) sols[i][j] else Long.MAX_VALUE
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxProductPath(arrayOf(
        intArrayOf(-1,-2,-3),
        intArrayOf(-2,-3,-3),
        intArrayOf(-3,-3,-2)
    )))
    println(sol.maxProductPath(arrayOf(
        intArrayOf(1,-2,1),
        intArrayOf(1,-2,1),
        intArrayOf(3,-4,1)
    )))
    println(sol.maxProductPath(arrayOf(
        intArrayOf(1,3),
        intArrayOf(0,-4)
    )))
    println(sol.maxProductPath(arrayOf(
        intArrayOf(4,3)
    )))
}