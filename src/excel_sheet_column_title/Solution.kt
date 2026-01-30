package excel_sheet_column_title

import kotlin.math.log

class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var rest = columnNumber
        val pows = IntArray(log(columnNumber.toDouble(), 26.0).toInt() + 1)
        pows[0] = 1
        for (i in 1 until pows.size) {
            pows[i] = pows[i - 1] * 26 + 1
        }
        val result = StringBuilder()
        var i = pows.size - 1
        while (i >= 0) {
            if (rest >= pows[i]) {
                result.append("A".repeat(i + 1))
                rest -= pows[i]
                var j = 0
                while (i > 0) {
                    result.setCharAt(j, 'A' + (rest / (pows[i] - pows[i - 1])))
                    rest -= (rest / (pows[i] - pows[i - 1])) * (pows[i] - pows[i - 1])
                    i--
                    j++
                }
                if (rest > 0) {
                    result[result.length - 1] = 'A' + rest
                }
                break
            }
            i--
        }
        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.convertToTitle(1))
    println(sol.convertToTitle(26))
    println(sol.convertToTitle(27))
    println(sol.convertToTitle(28))
    println(sol.convertToTitle(90_664))
    println(sol.convertToTitle(701))
    println(sol.convertToTitle(702))
    println(sol.convertToTitle(703))
}