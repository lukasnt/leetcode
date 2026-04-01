package predict_the_winner

class Solution {
    fun predictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        val score = Array(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            score[i][i] = nums[i]
        }
        for (k in 1 until n) {
            for (i in 0 until n - k) {
                score[i][i + k] = maxOf(
                    nums[i] - score[i + 1][i + k],
                    nums[i + k] - score[i][i + k - 1]
                )
            }
        }
        return score[0][n - 1] >= 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.predictTheWinner(intArrayOf(1,5,2)))
    println(sol.predictTheWinner(intArrayOf(1,5,233,7)))
    println(sol.predictTheWinner(intArrayOf(1,5,9,7,1)))
    println(sol.predictTheWinner(intArrayOf(1,5,10,7,1)))
}