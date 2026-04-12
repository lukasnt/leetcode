package k_diff_pairs_in_array

class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        if (k == 0) return findPairsZero(nums)
        var pairs = 0
        val checked = HashSet<Int>()
        for (num in nums) {
            if (num !in checked) {
                pairs += if (num + k in checked) 1 else 0
                pairs += if (num - k in checked) 1 else 0
                checked.add(num)
            }
        }
        return pairs
    }

    fun findPairsZero(nums: IntArray): Int {
        val checked = HashSet<Int>()
        val pairNums = HashSet<Int>()
        for (num in nums) {
            if (num in checked) pairNums.add(num)
            checked.add(num)
        }
        return pairNums.size
    }
}

fun main() {
    val sol = Solution()
    println(sol.findPairs(intArrayOf(3,1,4,1,5), 2))
    println(sol.findPairs(intArrayOf(1,2,3,4,5), 1))
    println(sol.findPairs(intArrayOf(1,3,1,5,4), 0))
    println(sol.findPairs(intArrayOf(1,3,1,5,4,1,1,1), 0))
    println(sol.findPairs(intArrayOf(1,3,1,5,4,1,1,1,3,4), 0))
}