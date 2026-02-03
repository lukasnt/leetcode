package contains_duplicates

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }
}

fun main() {
    val sol = Solution()
    println(sol.containsDuplicate(intArrayOf(1,2,3,1,1)))
    println(sol.containsDuplicate(intArrayOf(1,2,3,4)))
    println(sol.containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}