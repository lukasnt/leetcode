package non_overlapping_intervals

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        var erases = 0
        var end = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0] < end) {
                erases++
                end = minOf(end, intervals[i][1])
            } else {
                end = intervals[i][1]
            }
        }
        return erases
    }
}

fun main() {
    val sol = Solution()
    println(sol.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))))
    println(sol.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(1,2), intArrayOf(1,2))))
    println(sol.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(2,3))))
    println(sol.eraseOverlapIntervals(arrayOf(intArrayOf(1,5), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5))))
    println(sol.eraseOverlapIntervals(arrayOf(intArrayOf(1,5), intArrayOf(2,5), intArrayOf(2,4), intArrayOf(4,5))))
}