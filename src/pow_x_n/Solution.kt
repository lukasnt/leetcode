package pow_x_n

import kotlin.math.abs
import kotlin.math.log2

class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        val l = log2(abs(n.toDouble())).toInt() + 1
        val sols: Array<Double> = Array(l) { 0.0 }
        sols[0] = if (n > 0) x else 1.0.div(x)
        for (i in 1 until l) {
            sols[i] = sols[i - 1].times(sols[i - 1])
        }
        val bin = abs(n).toString(2)
        var result: Double = 1.0
        for (i in 0 until bin.length) {
            if (bin[i] == '1') {
                result = result.times(sols[bin.length - 1 - i])
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.myPow(2.00000, 10))
    println(sol.myPow(2.10000, 3))
    println(sol.myPow(2.00000, -2))
    println(sol.myPow(2.00000, 0))
    println(sol.myPow(0.00000, 2))
    println(sol.myPow(1.00000, -2147483648))
}