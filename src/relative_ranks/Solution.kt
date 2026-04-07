package relative_ranks

class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        val sorted = score.withIndex().sortedByDescending { it.value }
        val result = Array(score.size) { "" }
        for (i in sorted.indices) {
            result[sorted[i].index] = when (i) {
                0 -> "Gold Medal"
                1 -> "Silver Medal"
                2 -> "Bronze Medal"
                else -> (i + 1).toString()
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findRelativeRanks(intArrayOf(5,4,3,2,1)).contentToString())
    println(sol.findRelativeRanks(intArrayOf(10,3,8,9,4)).contentToString())

}