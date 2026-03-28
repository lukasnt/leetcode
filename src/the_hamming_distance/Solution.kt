package the_hamming_distance

class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        val ones = IntArray(32) { 0 }
        nums.map { it.toString(2).padStart(32, '0') }.forEach {
            it.forEachIndexed { i, c ->
                if (c == '1') ones[i]++
            }
        }
        return ones.sumOf { (nums.size - it) * it }
    }
}

fun main() {
    val sol = Solution()
    println(sol.totalHammingDistance(intArrayOf(4,14,2)))
    println(sol.totalHammingDistance(intArrayOf(4,14,4)))
}