package number_of_islands

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val visited: MutableSet<Pair<Int, Int>> = HashSet(m * n)
        var result = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1' && !visited.contains(Pair(i, j))) {
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    queue.add(Pair(i, j))
                    while (!queue.isEmpty()) {
                        val (y, x) = queue.removeFirst()
                        visited.add(Pair(y, x))
                        val left  = Pair(y, x - 1)
                        val right = Pair(y, x + 1)
                        val up    = Pair(y - 1, x)
                        val down  = Pair(y + 1, x)
                        if (left.second >= 0 && grid[y][left.second] == '1' && !visited.contains(left)) {
                            queue.add(left)
                            visited.add(left)
                        }
                        if (right.second < n && grid[y][right.second] == '1' && !visited.contains(right)) {
                            queue.add(right)
                            visited.add(right)
                        }
                        if (up.first >= 0 && grid[up.first][x] == '1' && !visited.contains(up)) {
                            queue.add(up)
                            visited.add(up)
                        }
                        if (down.first < m && grid[down.first][x] == '1' && !visited.contains(down)) {
                            queue.add(down)
                            visited.add(down)
                        }
                    }
                    result++
                }
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.numIslands(arrayOf(
        charArrayOf('1','1','1','1','0'),
        charArrayOf('1','1','0','1','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','0','0','0'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1','1','0','0','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','1','0','0'),
        charArrayOf('0','0','0','1','1'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1','1','0','0','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','1','1','0','0'),
        charArrayOf('0','0','1','1','1'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1','1','0','1','1'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','1','1','0','0'),
        charArrayOf('0','0','1','1','1'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1','1','0','0','0'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1','1','0','1','1'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1'),
        charArrayOf('1'),
        charArrayOf('0'),
        charArrayOf('1'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('1'),
    )))
    println(sol.numIslands(arrayOf(
        charArrayOf('0'),
    )))
    println(sol.numIslands(arrayOf(charArrayOf('1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'),charArrayOf('0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'),charArrayOf('1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'),charArrayOf('0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'),charArrayOf('1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),charArrayOf('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'))))
}