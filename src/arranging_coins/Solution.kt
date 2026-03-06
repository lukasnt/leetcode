package arranging_coins

import kotlin.math.sqrt

class Solution {
    fun arrangeCoins(n: Int): Int {
        // r * (r + 1) / 2 = n
        // r^2 + r - 2n = 0
        // r = (-1 + sqrt(1 + 8n)) / 2
        return ((sqrt(1.0 + 8.0 * n) - 1.0) / 2.0).toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.arrangeCoins(2))
    println(sol.arrangeCoins(3))
    println(sol.arrangeCoins(4))
    println(sol.arrangeCoins(5))
    println(sol.arrangeCoins(6))
    println(sol.arrangeCoins(8))
    println(sol.arrangeCoins(9))
    println(sol.arrangeCoins(10))
    println(sol.arrangeCoins(14))
    println(sol.arrangeCoins(15))
    println(sol.arrangeCoins(Int.MAX_VALUE))
}