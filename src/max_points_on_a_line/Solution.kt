package max_points_on_a_line

class Solution {

    data class Line(val a: String, val b: String)

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size < 2) return points.size
        val lines: MutableMap<Line, Int> = HashMap()
        for (i in 0 until points.size) {
            val newLines: MutableSet<Line> = HashSet()
            for (j in i + 1 until points.size) {
                val a: Double = (points[j][1] - points[i][1]).toDouble() / (points[j][0] - points[i][0]).toDouble()
                val b: Double = points[i][1] - a * points[i][0]
                if (a.isInfinite()) {
                    newLines.add(Line("Infinity", points[i][0].toString()))
                } else {
                    newLines.add(Line(stringRound(a, 8), stringRound(b, 8)))
                }
            }
            for (line in newLines) {
                lines.compute(line) { _, v -> if (v == null) 1 else v + 1 }
            }
        }
        return lines.values.max() + 1
    }

    fun stringRound(num: Double, digits: Int): String {
        return String.format("%.${digits}f", num)
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxPoints(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))))
    println(sol.maxPoints(arrayOf(intArrayOf(1, 1), intArrayOf(3, 2), intArrayOf(5, 3), intArrayOf(4, 1), intArrayOf(2, 3), intArrayOf(1, 4))))
    println(sol.maxPoints(arrayOf(intArrayOf(1, 1))))
    println(sol.maxPoints(arrayOf()))
    println(sol.maxPoints(arrayOf(intArrayOf(1, 1), intArrayOf(4, 5), intArrayOf(7, 9))))
    println(sol.maxPoints(arrayOf(intArrayOf(4, 5), intArrayOf(4, -1), intArrayOf(4, 0))))
}