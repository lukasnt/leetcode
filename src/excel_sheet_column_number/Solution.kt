package excel_sheet_column_number

class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        val pows = Array(columnTitle.length) { 1 }
        for (i in 0 until columnTitle.length) {
            if (i > 0) {
                pows[i] = pows[i - 1] * 26
            }
            result += (columnTitle[columnTitle.length - i - 1] - 'A' + 1) * pows[i]
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.titleToNumber("A"))
    println(sol.titleToNumber("B"))
    println(sol.titleToNumber("Z"))
    println(sol.titleToNumber("AA"))
    println(sol.titleToNumber("AB"))
    println(sol.titleToNumber("ZY"))
    println(sol.titleToNumber("FXSHRXW"))
}