package longest_consecutive_sequence

import kotlin.math.max

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val start: MutableMap<Int, Int> = HashMap()
        val end: MutableMap<Int, Int> = HashMap()
        for (num in nums) {
            if (start.containsKey(num) && end.containsKey(num)) {
                val mergedLength = start.getOrDefault(num, 0) + end.getOrDefault(num, 0) + 1
                maxPut(end, num + start.getOrDefault(num, 0) + 1, mergedLength)
                maxPut(start, num - end.getOrDefault(num, 0) - 1, mergedLength)
                end.remove(num)
                start.remove(num)
            } else if (start.containsKey(num)) {
                maxPut(start, num - 1, start.getOrDefault(num, 0) + 1)
                maxPut(end, num + start.getOrDefault(num - 1, 0), start.getOrDefault(num - 1, 0))
                start.remove(num)
            } else if (end.containsKey(num)) {
                maxPut(end, num + 1, end.getOrDefault(num, 0) + 1)
                maxPut(start, num - end.getOrDefault(num + 1, 0), end.getOrDefault(num + 1, 0))
                end.remove(num)
            } else {
                maxPut(start, num - 1, 1)
                maxPut(end, num + 1, 1)
            }
        }
        return max(start.values.max(), end.values.max())
    }

    fun maxPut(map: MutableMap<Int, Int>, key: Int, value: Int) {
        map[key] = max(map.getOrDefault(key, 0), value)
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(sol.longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
    println(sol.longestConsecutive(intArrayOf(1,0,1,2)))
    println(sol.longestConsecutive(intArrayOf()))
    println(sol.longestConsecutive(intArrayOf(7,-2,9,9,1,9,8,-4,6,-6,-6,4,1,3,6,3,5,-2,3,4,-6,1,5,-9,6,1,2,-2,1)))
}