package arithmetic_slices

class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0
        var result = 0
        var count = 1
        var last = nums[1] - nums[0]
        for (i in 2 until nums.size) {
            val diff = nums[i] - nums[i - 1]
            if (diff != last) {
                if (count >= 2) {
                    result += (count - 1) * count / 2
                }
                count = 0
                last = diff
            }
            count++
        }
        if (count >= 2) {
            result += (count - 1) * count / 2
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.numberOfArithmeticSlices(intArrayOf(1,2,3,4)))
    println(sol.numberOfArithmeticSlices(intArrayOf(1,2,3)))
    println(sol.numberOfArithmeticSlices(intArrayOf(0)))
    println(sol.numberOfArithmeticSlices(intArrayOf(1,2,3,4,9,10,20,30,40,50,61,62)))
    println(sol.numberOfArithmeticSlices(intArrayOf(1,2,3,4,5,6,7)))
}