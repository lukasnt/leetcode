package find_all_duplicates_in_an_array

class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        val duplicates = ArrayList<Int>()
        for (i in 0 until nums.size) {
            var current = nums[i]
            if (current != i + 1) {
                var next = nums[current - 1]
                nums[current - 1] = current
                if (current == next) {
                    duplicates.add(current)
                    continue
                }
                while (current > i + 1) {
                    current = next
                    next = nums[current - 1]
                    nums[current - 1] = current
                    if (current == next) {
                        duplicates.add(current)
                        break
                    }
                }
            }
        }
        return duplicates
    }
}

fun main() {
    val sol = Solution()
    println(sol.findDuplicates(intArrayOf(4,3,2,7,8,2,3,1)))
    println(sol.findDuplicates(intArrayOf(1,3,2,8,7,2,3,4,1)))
    println(sol.findDuplicates(intArrayOf(1,1,2)))
    println(sol.findDuplicates(intArrayOf(1)))
    println(sol.findDuplicates(intArrayOf(2,2)))
}