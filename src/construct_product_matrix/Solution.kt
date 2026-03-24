package construct_product_matrix

class Solution {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        val to   = IntArray(m * n) { 0 }
        val from = IntArray(m * n) { 0 }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val fi = m - i - 1
                val fj = n - j - 1
                val toIndex   = i  * n + j
                val fromIndex = fi * n + fj
                val toPrev   = if (toIndex > 0) to[toIndex - 1]     else 1
                val fromPrev = if (toIndex > 0) from[fromIndex + 1] else 1
                to[toIndex]     = toPrev   * (grid[i][j] % 12345)   % 12345
                from[fromIndex] = fromPrev * (grid[fi][fj] % 12345) % 12345
            }
        }
        return Array(m) { i ->
            IntArray(n) { j ->
                val index = i * n + j
                val toProd   = if (index > 0)         to[index - 1]   else 1
                val fromProd = if (index < n * m - 1) from[index + 1] else 1
                toProd * fromProd % 12345
            }
        }
    }

    fun solvePrint(grid: Array<IntArray>) {
        val result = constructProductMatrix(grid)
        result.forEach { println(it.contentToString()) }
        println()
    }

}

fun main() {
    val sol = Solution()
    sol.solvePrint(arrayOf(
        intArrayOf(1,2),
        intArrayOf(3,4)
    ))
    sol.solvePrint(arrayOf(
        intArrayOf(12345),
        intArrayOf(2),
        intArrayOf(1)
    ))
    sol.solvePrint(arrayOf(
        intArrayOf(5),
        intArrayOf(2)
    ))
    sol.solvePrint(arrayOf(
        intArrayOf(5,2)
    ))
}