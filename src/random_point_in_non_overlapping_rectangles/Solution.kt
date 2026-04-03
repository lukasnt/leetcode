package random_point_in_non_overlapping_rectangles

import java.util.TreeMap
import kotlin.random.Random

class Solution(rects: Array<IntArray>) {

    val offsets = TreeMap<Int, IntArray>()
    val total: Int

    init {
        var area = 0
        for (rect in rects) {
            val dx = rect[2] - rect[0] + 1
            val dy = rect[3] - rect[1] + 1
            area += dx * dy
            offsets[area] = rect
        }
        total = area
    }

    fun pick(): IntArray {
        val offsetKey = Random.nextInt(0, total)
        val (offset, rect) = offsets.higherEntry(offsetKey)
        val dx = rect[2] - rect[0] + 1
        val dy = rect[3] - rect[1] + 1
        val area = dx * dy
        val shifted = offsetKey - (offset - area)
        return intArrayOf(rect[0] + shifted % dx, rect[1] + shifted / dx)
    }

}

fun main() {
    var sol = Solution(arrayOf(
        intArrayOf(-2,-2,1,1),
        intArrayOf(2,2,4,6),
        intArrayOf(3,-1,4,1)
    ))
    (1..1000)
        .map {sol.pick().contentToString() }
        .groupBy { it }
        .map { it.key to it.value.size }
        .sortedBy { it.first }
        .forEach { println(it) }
}