package insert_interval

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var j = 1
        var i = 0
        val merged = newInterval.copyOf()
        var pos = 0
        var removed = 0
        while (i < intervals.size) {
            val interval = intervals[i]
            if ((i == 0 && newInterval[0] < interval[0])
                || (newInterval[0] >= interval[0]
                        && (i >= intervals.size - 1 || newInterval[0] <= intervals[i + 1][0]))) {
                if (newInterval[0] <= interval[1] && newInterval[1] >= interval[0]) {
                    merged[0] = minOf(merged[0], interval[0])
                    merged[1] = maxOf(merged[1], interval[1])
                    removed++
                    pos = i
                } else if (newInterval[1] < interval[0]) {
                    pos = i
                } else {
                    pos = i + 1
                }
                while (j + i < intervals.size && merged[1] >= intervals[i + j][0]) {
                    merged[0] = minOf(merged[0], intervals[i + j][0])
                    merged[1] = maxOf(merged[1], intervals[i + j][1])
                    j++
                }
                removed += j - 1
                break
            }
            i++
        }
        return Array(intervals.size + 1 - removed) { index ->
            if (index < pos) intervals[index]
            else if (index == pos) merged
            else intervals[index + removed - 1]
        }
    }

    fun solvePrint(intervals: Array<IntArray>, newInterval: IntArray): Unit {
        println(insert(intervals, newInterval).contentDeepToString())
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrint(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))
    sol.solvePrint(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
        intArrayOf(4, 8)
    )
    sol.solvePrint(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
        intArrayOf(2, 5)
    )
    sol.solvePrint(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
        intArrayOf(17, 18)
    )
    sol.solvePrint(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)),
        intArrayOf(16, 18)
    )
    sol.solvePrint(
        arrayOf(intArrayOf(1, 5)),
        intArrayOf(0, 3)
    )
    sol.solvePrint(
        arrayOf(intArrayOf(1, 5)),
        intArrayOf(0, 0)
    )
}