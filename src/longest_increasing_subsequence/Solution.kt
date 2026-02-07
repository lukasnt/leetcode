package longest_increasing_subsequence

import java.util.TreeMap

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val sol: TreeMap<Int, Int> = TreeMap()
        for (num in nums) {
            sol[num] = (sol.headMap(num).values.maxOrNull() ?: 0) + 1
        }
        return sol.values.maxOrNull() ?: 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18)))
    println(sol.lengthOfLIS(intArrayOf(0,1,0,3,2,3)))
    println(sol.lengthOfLIS(intArrayOf(7,7,7,7,7,7,7)))
}