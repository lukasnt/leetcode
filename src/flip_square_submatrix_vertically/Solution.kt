package flip_square_submatrix_vertically

class Solution {
    fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        for (i in 0 until k / 2) {
            for (j in 0 until k) {
                val row = x + i
                val col = y + j
                val flipRow = x + k - i - 1
                val temp = grid[row][col]
                grid[row][col] = grid[flipRow][col]
                grid[flipRow][col] = temp
            }
        }
        return grid
    }

    fun solvePrint(grid: Array<IntArray>, x: Int, y: Int, k: Int) {
        val result = reverseSubmatrix(grid, x, y, k)
        result.forEach { println(it.contentToString()) }
        println()
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrint(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16),
    ), 1, 0, 3)
    sol.solvePrint(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16),
    ), 1, 2, 2)
    sol.solvePrint(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16),
    ), 2, 2, 2)
}