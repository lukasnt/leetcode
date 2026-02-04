package power_of_two

import kotlin.math.log2
import kotlin.math.ulp

class Solution3 {

    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0) return false
        val log = log2(n.toDouble())
        return log - log.toInt().toDouble() <= log.ulp
    }

}

fun main() {
    val sol = Solution3()
    println(sol.isPowerOfTwo(0))
    println(sol.isPowerOfTwo(1))
    println(sol.isPowerOfTwo(16))
    println(sol.isPowerOfTwo(8))
    println(sol.isPowerOfTwo(3))
    println(sol.isPowerOfTwo(4))
    println(sol.isPowerOfTwo(-4))
    println(sol.isPowerOfTwo(1073741824))
    println(sol.isPowerOfTwo(536870912))
}