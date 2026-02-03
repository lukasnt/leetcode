package maximal_square

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val squares: MutableSet<Pair<Int, Int>> = HashSet()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '1') {
                    squares.add(Pair(i, j))
                }
            }
        }
        var result = 0
        while (!squares.isEmpty()) {
            val removed: MutableSet<Pair<Int, Int>> = HashSet(squares.size)
            for (square in squares) {
                val right = Pair(square.first, square.second + 1)
                val down = Pair(square.first + 1, square.second)
                val diagonal = Pair(square.first + 1, square.second + 1)
                if (!squares.contains(right) || !squares.contains(down) || !squares.contains(diagonal)) {
                    removed.add(square)
                }
            }
            squares.removeAll(removed)
            result++
        }
        return result * result
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximalSquare(arrayOf(
        charArrayOf('1','0','1','0','0'),
        charArrayOf('1','0','1','1','1'),
        charArrayOf('1','1','1','1','1'),
        charArrayOf('1','0','0','1','0'))
    ))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('1','1','1','1','0'),
        charArrayOf('1','1','1','1','1'),
        charArrayOf('1','1','1','1','1'),
        charArrayOf('1','1','1','1','0'))
    ))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('0','1'),
        charArrayOf('1','0')
    )))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('1','1'),
        charArrayOf('1','1')
    )))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('0','0'),
        charArrayOf('0','0')
    )))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('1')
    )))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('0')
    )))
    println(sol.maximalSquare(arrayOf(
        charArrayOf('1','1','1','1','1','1','1','1'),
        charArrayOf('1','1','1','1','1','1','1','0'),
        charArrayOf('1','1','1','1','1','1','1','0'),
        charArrayOf('1','1','1','1','1','0','0','0'),
        charArrayOf('0','1','1','1','1','0','0','0'),
    )))
}