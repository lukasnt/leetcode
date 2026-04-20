package maximum_distance_between_a_pair_of_values

class Solution {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        val (m, n) = nums1.size to nums2.size
        var (i, j) = 0 to 0
        var distance = 0
        while (i < m && j < n) {
            if (nums2[j] >= nums1[i]) j++
            else i++
            distance = maxOf(distance, j - i - 1)
        }
        return distance
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxDistance(intArrayOf(55,30,5,4,2), intArrayOf(100,20,10,10,5)))
    println(sol.maxDistance(intArrayOf(2,2,2), intArrayOf(10,10,1)))
    println(sol.maxDistance(intArrayOf(30,29,19,5), intArrayOf(25,25,25,25,25)))
    println(sol.maxDistance(intArrayOf(25,25,25,25,25), intArrayOf(25,25,25,25,25)))
}