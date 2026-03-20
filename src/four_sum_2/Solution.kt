package four_sum_2

class Solution {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val n = nums1.size
        val twoSums1 = HashMap<Int, Int>()
        val twoSums2 = HashMap<Int, Int>()
        for (i in 0 until n) {
            for (j in 0 until n) {
                val sum1 = nums1[i] + nums2[j]
                val sum2 = nums3[i] + nums4[j]
                twoSums1[sum1] = twoSums1.getOrDefault(sum1, 0) + 1
                twoSums2[sum2] = twoSums2.getOrDefault(sum2, 0) + 1
            }
        }
        var result = 0
        for (sum in twoSums1.keys) {
            result += twoSums1.getOrDefault(sum, 0) * twoSums2.getOrDefault(-sum, 0)
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.fourSumCount(intArrayOf(1,2), intArrayOf(-2,-1), intArrayOf(-1,2), intArrayOf(0,2)))
    println(sol.fourSumCount(intArrayOf(0), intArrayOf(0), intArrayOf(0), intArrayOf(0)))
}