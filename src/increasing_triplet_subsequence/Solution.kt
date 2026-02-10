package increasing_triplet_subsequence

class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var minSingle = nums[0]
        var minDouble = Int.MAX_VALUE
        for (i in 1 until nums.size) {
            if (nums[i] > minDouble) return true
            else if (nums[i] > minSingle) minDouble = minOf(minDouble, nums[i])
            else minSingle = nums[i]
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.increasingTriplet(intArrayOf(1,2,3,4,5)))
    println(sol.increasingTriplet(intArrayOf(5,4,3,2,1)))
    println(sol.increasingTriplet(intArrayOf(2,1,5,0,4,6)))
}