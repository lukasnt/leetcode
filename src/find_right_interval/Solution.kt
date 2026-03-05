package find_right_interval

import java.util.TreeMap

class Solution {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val startSorted = intervals.withIndex()
            .associate { it.value.first() to it.index }
            .toSortedMap() as TreeMap<Int, Int>
        val result = IntArray(intervals.size)
        for (i in 0 until intervals.size) {
            val end = intervals[i].last()
            val index = startSorted.ceilingEntry(end)?.value
            result[i] = index ?: -1
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findRightInterval(arrayOf(intArrayOf(1,2))).contentToString())
    println(sol.findRightInterval(arrayOf(intArrayOf(3,4), intArrayOf(2,3), intArrayOf(1,2))).contentToString())
    println(sol.findRightInterval(arrayOf(intArrayOf(1,4), intArrayOf(2,3), intArrayOf(3,4))).contentToString())
}