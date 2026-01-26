package gray_code

import kotlin.math.pow

class Solution {
    fun grayCode(n: Int): List<Int> {
        if (n == 1) return listOf(0, 1)
        val result = ArrayList<Int>(2.0.pow(n.toDouble()).toInt())
        val prev = grayCode(n - 1)
        for (num in prev) {
            result.add((num.toString(2).padStart(n - 1, '0') + "0").toInt(2))
        }
        for (num in prev.reversed()) {
            result.add((num.toString(2).padStart(n - 1, '0') + "1").toInt(2))
        }
        return result
    }

    fun solvePrintBin(n: Int): Unit {
        println(grayCode(n).map { it.toString(2).padStart(n, '0') })
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrintBin(1)
    println(sol.grayCode(1))
    sol.solvePrintBin(2)
    println(sol.grayCode(2))
    sol.solvePrintBin(3)
    println(sol.grayCode(3))
    sol.solvePrintBin(4)
    println(sol.grayCode(4))
}