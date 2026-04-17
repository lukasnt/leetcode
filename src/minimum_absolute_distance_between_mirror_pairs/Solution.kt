package minimum_absolute_distance_between_mirror_pairs

import kotlin.math.abs

class Solution {
    fun minMirrorPairDistance(nums: IntArray): Int {
        var minDistance = Int.MAX_VALUE
        val reversedIndices = HashMap<Int, Int>()
        for (i in nums.indices) {
            val num = nums[i]
            val reversed = reverse(num)
            if (num in reversedIndices.keys) {
                minDistance = minOf(minDistance, abs(i - reversedIndices[num]!!))
            }
            reversedIndices[reversed] = i
        }
        return if (minDistance != Int.MAX_VALUE) minDistance else -1
    }

    private fun reverse(num: Int): Int {
        return num.toString().reversed().toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.minMirrorPairDistance(intArrayOf(12,21,45,33,54)))
    println(sol.minMirrorPairDistance(intArrayOf(120,21)))
    println(sol.minMirrorPairDistance(intArrayOf(21,120)))
    println(sol.minMirrorPairDistance(intArrayOf(21,111,12)))
}