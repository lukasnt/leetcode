package sqrt_x

import kotlin.math.abs

class Solution {
    fun mySqrt(x: Int): Int {
        var prev: Double = 0.5 * x.toDouble()
        var next: Double = 0.5 * (prev + x / prev)
        while (abs(next - prev) >= 0.5) {
            prev = next
            next = 0.5 * (prev + x / prev)
        }
        return next.toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.mySqrt(2))
    println(sol.mySqrt(8))
    println(sol.mySqrt(9))
    println(sol.mySqrt(64))
    println(sol.mySqrt(63))
    println(sol.mySqrt(0))
}