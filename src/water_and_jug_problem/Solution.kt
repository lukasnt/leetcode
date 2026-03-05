package water_and_jug_problem

class Solution {
    fun canMeasureWater(x: Int, y: Int, target: Int): Boolean {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = HashSet<Pair<Int, Int>>()
        queue.add(x to 0)
        queue.add(0 to y)
        while (queue.isNotEmpty()) {
            val (a, b) = queue.removeFirst()
            println(a to b)
            visited.add(a to b)
            if (a + b == target) return true
            if (x to b !in visited) queue.add(x to b)
            if (a to y !in visited) queue.add(a to y)
            if (a to 0 !in visited) queue.add(a to 0)
            if (0 to b !in visited) queue.add(0 to b)
            val toA = minOf(a + b, x) - a
            val toB = minOf(a + b, y) - b
            if (a + toA to b - toA !in visited) queue.add(a + toA to b - toA)
            if (a - toB to b + toB !in visited) queue.add(a - toB to b + toB)
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.canMeasureWater(3, 5, 4))
    println(sol.canMeasureWater(2, 6, 5))
    println(sol.canMeasureWater(1, 2, 3))
    println(sol.canMeasureWater(750, 1000, 500))
}