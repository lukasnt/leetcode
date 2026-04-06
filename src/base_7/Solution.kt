package base_7

import kotlin.math.abs

class Solution {
    fun convertToBase7(num: Int): String {
        if (num == 0) return "0"
        val powers = IntArray(12) { 0 }
        var i = 0
        var pow = 1
        while (pow <= abs(num)) {
            powers[i++] = pow
            pow *= 7
        }
        i--
        val result = StringBuilder()
        if (num < 0) result.append('-')
        var rest = abs(num)
        while (i >= 0) {
            val digit = rest / powers[i]
            rest -= digit * powers[i]
            result.append(digit)
            i--
        }
        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.convertToBase7(100))
    println(sol.convertToBase7(-7))
    println(sol.convertToBase7(0))
    println(sol.convertToBase7(49))
    println(sol.convertToBase7(7))
    println(sol.convertToBase7(1))
    println(sol.convertToBase7(50))
    println(sol.convertToBase7(8))
}