package island_perimeter

class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (getCell(i, j, grid)) {
                    if (!getCell(i - 1, j, grid)) perimeter++
                    if (!getCell(i + 1, j, grid)) perimeter++
                    if (!getCell(i, j - 1, grid)) perimeter++
                    if (!getCell(i, j + 1, grid)) perimeter++
                }
            }
        }
        return perimeter
    }

    private fun getCell(row: Int, col: Int, grid: Array<IntArray>): Boolean {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size) return false
        return grid[row][col] == 1
    }
}

fun main() {
    val sol = Solution()
    println(sol.islandPerimeter(arrayOf(
        intArrayOf(0,1,0,0),
        intArrayOf(1,1,1,0),
        intArrayOf(0,1,0,0),
        intArrayOf(1,1,0,0)
    )))
    println(sol.islandPerimeter(arrayOf(
        intArrayOf(1)
    )))
    println(sol.islandPerimeter(arrayOf(
        intArrayOf(1,0)
    )))
}