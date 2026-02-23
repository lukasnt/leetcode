package wiggle_subsequence

class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        val n = nums.size
        val positives = IntArray(n) { 1 }
        val negatives = IntArray(n) { 1 }
        for (i in 1 until n) {
            val num = nums[i]
            for (j in 0 until i) {
                if (num > nums[j]) {
                    positives[i] = maxOf(positives[i], negatives[j] + 1)
                }
                if (num < nums[j]) {
                    negatives[i] = maxOf(negatives[i], positives[j] + 1)
                }
            }
        }
        return maxOf(positives[n - 1], negatives[n - 1])
    }
}

fun main() {
    val sol = Solution()
    println(sol.wiggleMaxLength(intArrayOf(1,7,4,9,2,5)))
    println(sol.wiggleMaxLength(intArrayOf(1,17,5,10,13,15,10,5,16,8)))
    println(sol.wiggleMaxLength(intArrayOf(1,2,3,4,5,6,7,8,9)))
}