package find_all_numbers_disappeared_in_an_array

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = ArrayList<Int>()
        for (i in nums.indices) {
            var num = nums[i]
            var next = nums[num - 1]
            nums[num - 1] = num
            while (num != next) {
                num = next
                next = nums[num - 1]
                nums[num - 1] = num
            }
        }
        for (i in nums.indices) {
            if (nums[i] != i + 1) result.add(i + 1)
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findDisappearedNumbers(intArrayOf(4,3,2,7,8,2,3,1)))
    println(sol.findDisappearedNumbers(intArrayOf(1,1)))
}