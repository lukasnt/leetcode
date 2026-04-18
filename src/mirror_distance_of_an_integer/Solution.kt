package mirror_distance_of_an_integer

import kotlin.math.abs

class Solution {
    fun mirrorDistance(n: Int): Int {
        return abs(n - n.toString().reversed().toInt())
    }
}

fun main() {
    val sol = Solution()
    println(sol.mirrorDistance(25))
    println(sol.mirrorDistance(10))
    println(sol.mirrorDistance(7))
}