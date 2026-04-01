package max_consecutive_ones

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var consecutive = 0
        for (num in nums) {
            if (num == 1) {
                consecutive++
            } else {
                max = maxOf(max, consecutive)
                consecutive = 0
            }
        }
        return maxOf(max, consecutive)
    }
}

fun main() {
    val sol = Solution()
    println(sol.findMaxConsecutiveOnes(intArrayOf(1,1,0,1,1,1)))
    println(sol.findMaxConsecutiveOnes(intArrayOf(1,0,1,1,0,1)))
    println(sol.findMaxConsecutiveOnes(intArrayOf(0,0,0)))
    println(sol.findMaxConsecutiveOnes(intArrayOf(1)))
    println(sol.findMaxConsecutiveOnes(intArrayOf(1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1)))
    println(sol.findMaxConsecutiveOnes(intArrayOf(1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1)))
}