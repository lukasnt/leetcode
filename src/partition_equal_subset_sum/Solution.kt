package partition_equal_subset_sum

class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 == 1) return false
        val target = sum / 2
        val found = HashSet<Int>()
        for (num in nums) {
            if (num == target) return true
            if (num > target) return false
            val added = HashSet<Int>()
            for (prev in found) {
                if (prev + num == target) return true
                if (prev + num < target) {
                    added.add(prev + num)
                }
            }
            found.addAll(added)
            found.add(num)
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.canPartition(intArrayOf(1,5,11,5)))
    println(sol.canPartition(intArrayOf(1,2,3,5)))
    println(sol.canPartition(intArrayOf(2,3,5,10)))
    println(sol.canPartition(intArrayOf(
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,
        10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50,10,50,110,50
    )))
}