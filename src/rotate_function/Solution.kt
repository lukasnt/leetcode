package rotate_function

class Solution {
    fun maxRotateFunction(nums: IntArray): Int {
        val n = nums.size
        var init = 0
        for (i in 0 until n) {
            init += i * nums[i]
        }
        var result = init
        var next = init
        val sum = nums.sum()
        for (i in n - 1 downTo 0) {
            next += sum
            next -= n * nums[i]
            result = maxOf(result, next)
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxRotateFunction(intArrayOf(4,3,2,6)))
    println(sol.maxRotateFunction(intArrayOf(100)))
}