package search_a_2d_matrix_2

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return searchMatrix(matrix, target, 0, 0, matrix.size - 1, matrix[0].size - 1)
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int, startRow: Int, startCol: Int, endRow: Int, endCol: Int): Boolean {
        val midRow = (startRow + endRow) / 2
        val midCol = (startCol + endCol) / 2
        if (matrix[midRow][midCol] == target) return true
        else if (startRow == midRow && startCol == midCol) {
            return matrix[startRow][endCol] == target
                || matrix[endRow][startCol] == target
                || matrix[endRow][endCol]   == target
        }
        var botLeft = false
        if (midRow < endRow) {
            botLeft = searchMatrix(matrix, target, midRow + 1, startCol, endRow, midCol)
        }
        var topRight = false
        if (midCol < endCol) {
            topRight = searchMatrix(matrix, target, startRow, midCol + 1, midRow, endCol)
        }
        if (matrix[midRow][midCol] < target) {
            val botRight = searchMatrix(matrix, target, midRow, midCol, endRow, endCol)
            return botLeft || topRight || botRight
        } else {
            val topLeft = searchMatrix(matrix, target, startRow, startCol, midRow, midCol)
            return botLeft || topRight || topLeft
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15),
        intArrayOf(2,5,8,12,19),
        intArrayOf(3,6,9,16,22),
        intArrayOf(10,13,14,17,24),
        intArrayOf(18,21,23,26,30),
    ), 5))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15),
        intArrayOf(2,5,8,12,19),
        intArrayOf(3,6,9,16,22),
        intArrayOf(10,13,14,17,24),
        intArrayOf(18,21,23,26,30),
    ), 30))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15),
        intArrayOf(2,5,8,12,19),
        intArrayOf(3,6,9,16,22),
        intArrayOf(10,13,14,17,24),
        intArrayOf(18,21,23,26,30),
    ), 20))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15)
    ), 4))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15)
    ), 1))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15)
    ), 15))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15)
    ), 11))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15)
    ), 5))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,15)
    ), 8))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1),
        intArrayOf(4),
        intArrayOf(7),
        intArrayOf(11),
        intArrayOf(15),
    ), 4))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1),
        intArrayOf(4),
        intArrayOf(7),
        intArrayOf(11),
        intArrayOf(15),
    ), 1))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1),
        intArrayOf(4),
        intArrayOf(7),
        intArrayOf(11),
        intArrayOf(15),
    ), 15))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1),
        intArrayOf(4),
        intArrayOf(7),
        intArrayOf(11),
        intArrayOf(15),
    ), 8))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1),
    ), 8))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1),
    ), 1))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,20),
        intArrayOf(2,5,8,12,21),
        intArrayOf(3,6,9,16,22),
    ), 16))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,20),
        intArrayOf(2,5,8,12,21),
        intArrayOf(3,6,9,16,22),
    ), 22))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,20),
        intArrayOf(2,5,8,12,21),
        intArrayOf(3,6,9,16,22),
    ), 1))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,20),
        intArrayOf(2,5,8,12,21),
        intArrayOf(3,6,9,16,22),
    ), 20))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(1,4,7,11,20),
        intArrayOf(2,5,8,12,21),
        intArrayOf(3,6,9,16,22),
    ), 10))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(4,7,10,10,12,17,18,22,23,24),
        intArrayOf(7,9,10,15,18,22,22,25,27,27),
        intArrayOf(8,10,11,17,23,23,23,30,34,36)
    ), 4))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(4,7,10,10,12,17,18,22,23,24),
        intArrayOf(7,9,10,15,18,22,22,25,27,27),
        intArrayOf(8,10,11,17,23,23,23,30,34,36)
    ), 27))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(4,7,10,10,12,17,18,22,23,24),
        intArrayOf(7,9,10,15,18,22,22,25,27,27),
        intArrayOf(8,10,11,17,23,23,23,30,34,36)
    ), 10))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(4,7,10,10,12,17,18,22,23,24),
        intArrayOf(7,9,10,15,18,22,22,25,27,27),
        intArrayOf(8,10,11,17,23,23,23,30,34,36)
    ), 22))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(4,7,10,10,12,17,18,22,23,24),
        intArrayOf(7,9,10,15,18,22,22,25,27,27),
        intArrayOf(8,10,11,17,23,23,23,30,34,36)
    ), 37))
    println(sol.searchMatrix(arrayOf(
        intArrayOf(4,7,10,10,12,17,18,22,23,24),
        intArrayOf(7,9,10,15,18,22,22,25,27,27),
        intArrayOf(8,10,11,17,23,23,23,30,34,36)
    ), 1))
}