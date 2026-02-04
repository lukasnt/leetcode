package product_of_array_except_self

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var prod: Long = 1
        var zeroes = 0
        for (num in nums) {
            if (num != 0) {
                prod *= num
            } else {
                zeroes++
            }
        }
        return if (zeroes > 1) {
            IntArray(nums.size) { 0 }
        } else if (zeroes == 1) {
            IntArray(nums.size) {
                if (nums[it] == 0) prod.toInt() else 0
            }
        } else {
            IntArray(nums.size) {
                (prod / nums[it]).toInt()
            }
        }
    }

    fun printResult(result: IntArray) {
        println(result.contentToString())
    }

}

fun main() {
    val sol = Solution()
    sol.printResult(sol.productExceptSelf(intArrayOf(1,2,3,4)))
    sol.printResult(sol.productExceptSelf(intArrayOf(-1,1,0,-3,3)))
    sol.printResult(sol.productExceptSelf(intArrayOf(-1,1,0,-3,3,0)))
    sol.printResult(sol.productExceptSelf(intArrayOf(4,2)))
}