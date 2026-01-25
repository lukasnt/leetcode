package maximum_product_subarray

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var prod: Int = 1
        var maxProd = Int.MIN_VALUE
        var firstNegProd: Int? = null
        var count = 0
        for (num in nums) {
            if (num < 0 && firstNegProd == null) {
                firstNegProd = num * prod
            }
            if (num == 0) {
                prod = 1
                firstNegProd = null
                count = 0
                if (maxProd < 0) maxProd = 0
                continue
            } else {
                prod *= num
                count++
            }
            if (prod > maxProd) {
                maxProd = prod
            }
            if (firstNegProd != null && count >= 2 && prod / firstNegProd > maxProd) {
                maxProd = prod / firstNegProd
            }
        }
        return maxProd
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxProduct(intArrayOf(2,3,-2,4)))
    println(sol.maxProduct(intArrayOf(-2,0,-1)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,0,-1)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,-7,0,-2,127)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,-7,0,-2,127,2,3)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,-7,0,-2,127,2,3,-2)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,-7,0,2,-2,127,2,3,-2)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,-7,0,2,-2,127,2,3,-2,-2)))
    println(sol.maxProduct(intArrayOf(-2,-3,-3,-7,0,2,-2,127,2,3,-2,-2,0,6097)))
    println(sol.maxProduct(intArrayOf(0,10,10,0,0,10,10,10,0)))
    println(sol.maxProduct(intArrayOf(-2,1,1,1,1,0,-1)))
}