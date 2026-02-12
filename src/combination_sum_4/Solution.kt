package combination_sum_4

class Solution {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val sol = IntArray(target + 1)
        nums.sort()
        for (t in 1 until target + 1) {
            for (num in nums) {
                if (num > t) break
                if (num == t) sol[t]++
                else sol[t] += sol[t - num]
            }
        }
        return sol[target]
    }
}

fun main() {
    val sol = Solution()
    println(sol.combinationSum4(intArrayOf(1,2,3), 4))
    println(sol.combinationSum4(intArrayOf(9), 3))
    println(sol.combinationSum4(intArrayOf(9), 9))
    println(sol.combinationSum4(intArrayOf(9,1,3), 9))
}