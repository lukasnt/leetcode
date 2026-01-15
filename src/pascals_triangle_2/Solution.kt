package pascals_triangle_2

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) return listOf(1)
        val row = ArrayList<Int>(rowIndex)
        row.add(1)
        for (i in 1 until rowIndex + 1) {
            row.add(1)
            var next = row[0]
            for (j in 1 until i) {
                val temp = next
                next = row[j]
                row[j] = row[j] + temp
            }
        }
        return row
    }
}

fun main() {
    val sol = Solution()
    println(sol.getRow(0))
    println(sol.getRow(1))
    println(sol.getRow(2))
    println(sol.getRow(3))
    println(sol.getRow(4))
    println(sol.getRow(5))
}