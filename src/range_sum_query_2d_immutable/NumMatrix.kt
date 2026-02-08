package range_sum_query_2d_immutable

class NumMatrix(val matrix: Array<IntArray>) {

    val m = matrix.size
    val n = matrix[0].size
    val cumulative: Array<IntArray> = Array(m) { IntArray(n) }

    init {
        cumulative[0][0] = matrix[0][0]
        for (i in 1 until m) {
            cumulative[i][0] = cumulative[i - 1][0] + matrix[i][0]
        }
        for (j in 1 until n) {
            cumulative[0][j] = cumulative[0][j - 1] + matrix[0][j]
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                cumulative[i][j] += cumulative[i - 1][j]
                cumulative[i][j] += cumulative[i][j - 1]
                cumulative[i][j] -= cumulative[i - 1][j - 1]
                cumulative[i][j] += matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int,col1: Int,row2: Int,col2: Int): Int {
        var sum = cumulative[row2][col2]
        if (row1 > 0) sum -= cumulative[row1 - 1][col2]
        if (col1 > 0) sum -= cumulative[row2][col1 - 1]
        if (row1 > 0 && col1 > 0) sum += cumulative[row1 - 1][col1 - 1]
        return sum
    }
}

fun main() {
    val numMatrix = NumMatrix(arrayOf(
        intArrayOf(3,0,1,4,2),
        intArrayOf(5,6,3,2,1),
        intArrayOf(1,2,0,1,5),
        intArrayOf(4,1,0,1,7),
        intArrayOf(1,0,3,0,5))
    )
    println(numMatrix.sumRegion(2, 1, 4, 3))
    println(numMatrix.sumRegion(1, 1, 2, 2))
    println(numMatrix.sumRegion(1, 2, 2, 4))
    println(numMatrix.sumRegion(0, 0, 2, 4))
    println(numMatrix.sumRegion(3, 3, 4, 4))
}