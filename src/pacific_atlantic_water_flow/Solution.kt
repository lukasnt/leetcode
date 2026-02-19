package pacific_atlantic_water_flow

class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size
        val pacific = Array(m) { BooleanArray(n) { false } }
        val atlantic = Array(m) { BooleanArray(n) { false } }
        for (i in 0 until m) {
            followFlow(heights, pacific, i, 0)
            followFlow(heights, atlantic, i, n - 1)
        }
        for (j in 0 until n) {
            followFlow(heights, pacific, 0, j)
            followFlow(heights, atlantic, m - 1, j)
        }
        val result = ArrayList<List<Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (pacific[i][j] && atlantic[i][j]) result.add(listOf(i, j))
            }
        }
        return result
    }

    private fun followFlow(heights: Array<IntArray>, flow: Array<BooleanArray>, i: Int, j: Int) {
        val m = heights.size
        val n = heights[0].size
        flow[i][j] = true
        if (i > 0     && heights[i - 1][j] >= heights[i][j] && !flow[i - 1][j]) followFlow(heights, flow, i - 1, j)
        if (i < m - 1 && heights[i + 1][j] >= heights[i][j] && !flow[i + 1][j]) followFlow(heights, flow, i + 1, j)
        if (j > 0     && heights[i][j - 1] >= heights[i][j] && !flow[i][j - 1]) followFlow(heights, flow, i, j - 1)
        if (j < n - 1 && heights[i][j + 1] >= heights[i][j] && !flow[i][j + 1]) followFlow(heights, flow, i, j + 1)
    }
}

fun main() {
    val sol = Solution()
    println(sol.pacificAtlantic(arrayOf(
        intArrayOf(1,2,2,3,5),
        intArrayOf(3,2,3,4,4),
        intArrayOf(2,4,5,3,1),
        intArrayOf(6,7,1,4,5),
        intArrayOf(5,1,1,2,4),
    )))
    println(sol.pacificAtlantic(arrayOf(
        intArrayOf(1,2,2,3,5),
    )))
    println(sol.pacificAtlantic(arrayOf(
        intArrayOf(1),
        intArrayOf(2),
        intArrayOf(2),
        intArrayOf(3),
        intArrayOf(5),
    )))
}