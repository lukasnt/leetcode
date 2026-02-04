package summary_ranges

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()
        val result: MutableList<String> = ArrayList()
        var start = 0
        var end = 0
        for (i in 0 until nums.size - 1) {
            if (nums[i + 1] - nums[i] != 1) {
                if (start == end) {
                    result.add("${nums[start]}")
                } else {
                    result.add("${nums[start]}->${nums[end]}")
                }
                start = i + 1
                end = start
            } else {
                end++
            }
        }
        if (start == end) {
            result.add("${nums[start]}")
        } else {
            result.add("${nums[start]}->${nums[end]}")
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.summaryRanges(intArrayOf(0,1,2,4,5,7)))
    println(sol.summaryRanges(intArrayOf(0,2,3,4,6,8,9)))
    println(sol.summaryRanges(intArrayOf(0,1)))
    println(sol.summaryRanges(intArrayOf(0,2)))
    println(sol.summaryRanges(intArrayOf(0)))
    println(sol.summaryRanges(intArrayOf()))
}