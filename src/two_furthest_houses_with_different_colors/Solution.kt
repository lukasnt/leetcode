package two_furthest_houses_with_different_colors

import kotlin.math.abs

class Solution {
    fun maxDistance(colors: IntArray): Int {
        val (frontFirstColor , frontFirstIndex)  = colors[0] to 0
        val (backFirstColor  , backFirstIndex)   = colors[colors.size - 1] to colors.size - 1
        var (frontSecondColor, frontSecondIndex) = -1 to -1
        var (backSecondColor , backSecondIndex)  = -1 to -1
        for (i in 1 until colors.size) {
            if (colors[i] != frontFirstColor) {
                frontSecondColor = colors[i]
                frontSecondIndex = i
                break
            }
        }
        for (i in colors.size - 2 downTo 0) {
            if (colors[i] != backFirstColor) {
                backSecondColor = colors[i]
                backSecondIndex = i
                break
            }
        }
        return maxOf(
            if (frontFirstColor  != backFirstColor)  abs(backFirstIndex  - frontFirstIndex)  else 0,
            if (frontFirstColor  != backSecondColor) abs(backSecondIndex - frontFirstIndex)  else 0,
            if (frontSecondColor != backFirstColor)  abs(backFirstIndex  - frontSecondIndex) else 0,
            if (frontSecondColor != backSecondColor) abs(backSecondIndex - frontSecondIndex) else 0,
        )
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxDistance(intArrayOf(1,1,1,6,1,1,1)))
    println(sol.maxDistance(intArrayOf(1,8,3,8,3)))
    println(sol.maxDistance(intArrayOf(0,1)))
    println(sol.maxDistance(intArrayOf(4,4,4,11,4,4,11,4,4,4,4,4)))
}