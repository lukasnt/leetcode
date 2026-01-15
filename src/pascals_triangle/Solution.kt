package pascals_triangle


class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) return emptyList()
        val result = arrayListOf<List<Int>>()
        result.add(listOf(1))
        for (i in 1 until numRows) {
            val row = MutableList<Int>(i + 1) { 1 }
            for (j in 1 until i) {
                row[j] = result[i - 1][j - 1] + result[i - 1][j]
            }
            result.add(row)
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.generate(5))
    println(sol.generate(0))
    println(sol.generate(1))
    println(sol.generate(2))
    println(sol.generate(3))
    println(sol.generate(4))
    println(sol.generate(6))
}