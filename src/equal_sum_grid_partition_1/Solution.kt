package equal_sum_grid_partition_1

class Solution {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val rowCumulative = LongArray(m) { 0 }
        val colCumulative = LongArray(n) { 0 }
        for (i in 0 until m) {
            var rowSum = 0L
            for (j in 0 until n) {
                rowSum += grid[i][j]
                colCumulative[j] += rowSum
            }
            rowCumulative[i] = rowSum + if (i > 0) rowCumulative[i - 1] else 0
        }
        val total = rowCumulative[m - 1]
        return rowCumulative.any { it * 2 == total } || colCumulative.any { it * 2 == total }
    }
}

fun main() {
    val sol = Solution()
    println(sol.canPartitionGrid(arrayOf(
        intArrayOf(1,4),
        intArrayOf(2,3),
    )))
    println(sol.canPartitionGrid(arrayOf(
        intArrayOf(1,3),
        intArrayOf(2,4),
    )))
}