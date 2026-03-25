package heaters

import kotlin.math.abs

class Solution {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        houses.sort()
        heaters.sort()
        var radius = 0
        var j = 0
        for (i in houses.indices) {
            var diff = abs(houses[i] - heaters[j])
            while (j < heaters.size - 1 && abs(houses[i] - heaters[j + 1]) <= diff) {
                diff = abs(houses[i] - heaters[++j])
            }
            radius = maxOf(radius, diff)
        }
        return radius
    }
}

fun main() {
    val sol = Solution()
    println(sol.findRadius(intArrayOf(1,2,3), intArrayOf(2)))
    println(sol.findRadius(intArrayOf(1,2,3,4), intArrayOf(1,4)))
    println(sol.findRadius(intArrayOf(1,5), intArrayOf(2)))
    println(sol.findRadius(intArrayOf(2,2), intArrayOf(2)))
}