package number_of_boomerangs

import kotlin.math.sqrt

class Solution {
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        val distPairs = HashMap<Double, MutableList<Pair<Int, Int>>>()
        for (from in 0 until points.size) {
            for (to in 0 until points.size) {
                val dist = dist(points[from], points[to])
                if (!distPairs.containsKey(dist)) {
                    distPairs[dist] = ArrayList()
                }
                distPairs[dist]!!.add(from to to)
            }
        }
        var result = 0
        for (pairs in distPairs.values) {
            result += pairs
                .groupBy { it.first }
                .map { it.value.size * (it.value.size - 1) }
                .sum()
        }
        return result
    }

    private fun dist(a: IntArray, b: IntArray): Double {
        val dx = (b[0] - a[0]).toDouble()
        val dy = (b[1] - a[1]).toDouble()
        return sqrt(dx * dx + dy * dy)
    }
}

fun main() {
    val sol = Solution()
    println(sol.numberOfBoomerangs(arrayOf(intArrayOf(0,0), intArrayOf(1,0), intArrayOf(2,0))))
    println(sol.numberOfBoomerangs(arrayOf(intArrayOf(1,1), intArrayOf(2,2), intArrayOf(3,3))))
    println(sol.numberOfBoomerangs(arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,-1))))
    println(sol.numberOfBoomerangs(arrayOf(intArrayOf(1,1))))
}