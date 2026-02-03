package rectangle_area

class Solution {
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val areaA = (ax2 - ax1) * (ay2 - ay1)
        val areaB = (bx2 - bx1) * (by2 - by1)
        val overlapX = minOf(ax2, bx2) - maxOf(ax1, bx1)
        val overlapY = minOf(ay2, by2) - maxOf(ay1, by1)
        val overlap = (if (overlapX > 0) overlapX else 0) * (if (overlapY > 0) overlapY else 0)
        return areaA + areaB - overlap
    }
}

fun main() {
    val sol = Solution()
    println(sol.computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
    println(sol.computeArea(-2, -2, 2, 2, -2, -2, 2, 2))
}