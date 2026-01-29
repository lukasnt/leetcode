package search_in_rotated_sorted_array_2

class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        if (nums.size == 1) return nums[0] == target
        if (nums.size == 2) return nums[0] == target || nums[1] == target
        var low = 0
        var high = nums.size - 1
        var mid = (low + high) / 2
        while (low < high) {
            if (nums[mid] == target || nums[low] == target || nums[high] == target) {
                return true
            } else if (high - low <= 2) {
                return false
            } else if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++
                high--
            } else if (nums[mid - 1] >= nums[mid] && nums[mid] <= nums[mid + 1] && nums[mid - 1] != nums[mid + 1]) {
                if (nums[low] <= target && target <= nums[mid - 1]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
            mid = (low + high) / 2
        }
        return nums[mid] == target
    }
}

fun main() {
    val sol = Solution()
    println(sol.search(intArrayOf(2,5,6,0,0,1,2), 0))
    println(sol.search(intArrayOf(2,5,6,7,8,0,1,2), 0))
    println(sol.search(intArrayOf(2,5,6,7,8,0,1,2), 2))
    println(sol.search(intArrayOf(2,5,6,7,8,-1,0,0,1), 1))
    println(sol.search(intArrayOf(2,5,6,7,8,-1,0,0,1), -2))
    println(sol.search(intArrayOf(2,5,6,7,8,-1,0,0,1), 9))
    println(sol.search(intArrayOf(2,5,6,7,8,-1,0,0,1), 4))
    println(sol.search(intArrayOf(0,0,0,0,0,0,0,0,0,1), 1))
    println(sol.search(intArrayOf(0,0,0,0,0,0,0,0,0,0), 1))
    println(sol.search(intArrayOf(0,0,1,0,0,0,0,0,0,0), 1))
    println(sol.search(intArrayOf(0,0,0,0,0,0,0,1,0,0), 1))
    println(sol.search(intArrayOf(0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,0,0,0), 3))
    println(sol.search(intArrayOf(0,0,0,0,0,0,0,0,0,0,0,1,2,2,2,2,2,3,4,4,4,4,4,5,0,0,0), 3))
    println(sol.search(intArrayOf(2,5,6), 0))
    println(sol.search(intArrayOf(2,5,6), 2))
    println(sol.search(intArrayOf(2,5,6), 5))
    println(sol.search(intArrayOf(2,5,6), 6))
    println(sol.search(intArrayOf(6,2,5), 6))
    println(sol.search(intArrayOf(6,2,5), 5))
    println(sol.search(intArrayOf(1,1,3,1,1), 2))
    println(sol.search(intArrayOf(3,1,1,1,1), 0))
    println(sol.search(intArrayOf(15,16,19,20,25,1,3,4,5,7,10,14), 25))
}