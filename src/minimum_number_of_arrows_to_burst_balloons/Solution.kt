package minimum_number_of_arrows_to_burst_balloons

class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        points.sortBy { it[0] }
        var arrows = 1
        var end = points[0][1]
        for (i in 1 until points.size) {
            if (points[i][0] <= end) {
                end = minOf(end, points[i][1])
            } else {
                end = points[i][1]
                arrows++
            }
        }
        return arrows
    }
}

fun main() {
    val sol = Solution()
    println(sol.findMinArrowShots(arrayOf(intArrayOf(10,16), intArrayOf(2,8), intArrayOf(1,6), intArrayOf(7,12))))
    println(sol.findMinArrowShots(arrayOf(intArrayOf(1,2), intArrayOf(3,4), intArrayOf(5,6), intArrayOf(7,8))))
    println(sol.findMinArrowShots(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5))))
    println(sol.findMinArrowShots(arrayOf(intArrayOf(1,2), intArrayOf(2,3))))
    println(sol.findMinArrowShots(arrayOf(intArrayOf(1,2), intArrayOf(3,3))))
    println(sol.findMinArrowShots(arrayOf(intArrayOf(1,2))))
    println(sol.findMinArrowShots(arrayOf()))
}