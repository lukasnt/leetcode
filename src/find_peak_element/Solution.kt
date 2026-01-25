package find_peak_element

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        return findPeakElement(nums, 0, nums.size - 1)
    }

    fun findPeakElement(nums: IntArray, start: Int, end: Int): Int {
        if (end <= start) return start
        val mid: Int = (start + end) / 2
        return if ((mid - 1 < 0 || nums[mid - 1] < nums[mid]) && (mid + 1 >= nums.size || nums[mid + 1] < nums[mid])) {
            mid
        } else if (mid - 1 >= 0 && nums[mid - 1] >= nums[mid]) {
            findPeakElement(nums, start, mid - 1)
        } else if (mid + 1 < nums.size && nums[mid + 1] >= nums[mid]) {
            findPeakElement(nums, mid + 1, end)
        } else {
            mid
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.findPeakElement(intArrayOf(1,2,3,1)))
    println(sol.findPeakElement(intArrayOf(1,2,1,3,5,6,4)))
    println(sol.findPeakElement(intArrayOf(11,1,2,22)))
    println(sol.findPeakElement(intArrayOf(1,2,3,4,5,2,1,-1,2,22)))
    println(sol.findPeakElement(intArrayOf(1,2,3,4,5,2,1,-1,2)))
    println(sol.findPeakElement(intArrayOf(1)))
    println(sol.findPeakElement(intArrayOf(1,2)))
    println(sol.findPeakElement(intArrayOf(2,1)))
}