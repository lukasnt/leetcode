package find_minimum_in_rotated_sorted_array

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var mid = (left + right) / 2
        while (left < right) {
            if (nums[left] >= nums[mid] && nums[right] >= nums[mid]) {
                right = mid
            } else if (nums[left] <= nums[mid] && nums[right] <= nums[mid]) {
                left = mid + 1
            } else if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                right = mid
            } else if (nums[right] <= nums[mid] && nums[mid] <= nums[left]) {
                left = mid + 1
            }
            mid = (left + right) / 2
        }
        return nums[mid]
    }
}

fun main() {
    val sol = Solution()
    println(sol.findMin(intArrayOf(3,4,5,1,2)))
    println(sol.findMin(intArrayOf(4,5,6,7,0,1,2)))
    println(sol.findMin(intArrayOf(11,13,15,17)))
    println(sol.findMin(intArrayOf(11,13)))
    println(sol.findMin(intArrayOf(13,11)))
    println(sol.findMin(intArrayOf(11)))
    println(sol.findMin(intArrayOf(11,13,14)))
    println(sol.findMin(intArrayOf(14,11,13)))
    println(sol.findMin(intArrayOf(13,14,11)))
}