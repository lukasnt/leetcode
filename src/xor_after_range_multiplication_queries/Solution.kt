package xor_after_range_multiplication_queries

class Solution {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        for (query in queries) {
            val (l, r, k, v) = query
            var idx = l
            while (idx <= r) {
                nums[idx] = ((nums[idx].toLong() * v) % 1_000_000_007).toInt()
                idx += k
            }
        }
        return nums.reduce { a, b -> a xor b }
    }
}

fun main() {
    val sol = Solution()
    println(sol.xorAfterQueries(intArrayOf(1,1,1), arrayOf(intArrayOf(0,2,1,4))))
    println(sol.xorAfterQueries(intArrayOf(2,3,1,5,4), arrayOf(
        intArrayOf(1,4,2,3), intArrayOf(0,2,1,2)),
    ))
    println(sol.xorAfterQueries(intArrayOf(780), arrayOf(
        intArrayOf(0,0,1,13), intArrayOf(0,0,1,17), intArrayOf(0,0,1,9),  intArrayOf(0,0,1,18), intArrayOf(0,0,1,16),
        intArrayOf(0,0,1,6),  intArrayOf(0,0,1,4),  intArrayOf(0,0,1,11), intArrayOf(0,0,1,7),  intArrayOf(0,0,1,18),
        intArrayOf(0,0,1,8),  intArrayOf(0,0,1,15), intArrayOf(0,0,1,12))
    ))
}