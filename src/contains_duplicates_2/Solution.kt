package contains_duplicates_2

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window: MutableSet<Int> = HashSet()
        for (j in 0 until minOf(k + 1, nums.size)) {
            if (window.contains(nums[j])) {
                return true
            }
            window.add(nums[j])
        }
        for (i in k + 1 until nums.size) {
            window.remove(nums[i - k - 1])
            if (window.contains(nums[i])) {
                return true
            }
            window.add(nums[i])
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
    println(sol.containsNearbyDuplicate(intArrayOf(1,0,1,1), 1))
    println(sol.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
    println(sol.containsNearbyDuplicate(intArrayOf(1), 1))
}