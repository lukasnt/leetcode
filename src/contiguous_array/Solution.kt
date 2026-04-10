package contiguous_array

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val extrasIndices = HashMap<Int, Int>()
        var maxLength = 0
        var extras = 0
        for (i in nums.indices) {
            extras += if (nums[i] == 1) 1 else -1
            if (extras == 0) {
                maxLength = i + 1
            } else if (extrasIndices[extras] != null) {
                maxLength = maxOf(maxLength, i - extrasIndices[extras]!!)
            } else {
                extrasIndices[extras] = i
            }
        }
        return maxLength
    }
}

fun main() {
    val sol = Solution()
    println(sol.findMaxLength(intArrayOf(0,1)))
    println(sol.findMaxLength(intArrayOf(0,1,0)))
    println(sol.findMaxLength(intArrayOf(0,1,1,1,1,1,0,0,0)))
}