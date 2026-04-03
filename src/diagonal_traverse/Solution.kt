package diagonal_traverse

class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat[0].size
        val result = IntArray(m * n)
        var row = 0
        var col = 0
        var dir = 1
        var i = 0
        while (i < m * n) {
            result[i++] = mat[row][col]
            if (row - dir !in 0..<m && col + 1 < n) {
                col++
                dir *= -1
            } else if (col + dir !in 0..<n && row + 1 < m) {
                row++
                dir *= -1
            } else {
                row -= dir
                col += dir
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2),
        intArrayOf(3,4),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2,3,10),
        intArrayOf(4,5,6,11),
        intArrayOf(7,8,9,12),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
        intArrayOf(10,11,12),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2,3,10,13),
        intArrayOf(4,5,6,11,14),
        intArrayOf(7,8,9,12,15),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
        intArrayOf(10,11,12),
        intArrayOf(13,14,15),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1,2,3,4),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1),
        intArrayOf(2),
        intArrayOf(3),
        intArrayOf(4),
    )).contentToString())
    println(sol.findDiagonalOrder(arrayOf(
        intArrayOf(1)
    )).contentToString())
}