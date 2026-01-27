package next_permutation

class Solution2 {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size == 1) return
        subNextPermutation(nums, 0)
    }

    fun subNextPermutation(nums: IntArray, start: Int): Boolean {
        val tmp = nums[start]
        if (nums.size - start <= 2) {
            nums[start] = nums[start + 1]
            nums[start + 1] = tmp
            return tmp < nums[start]
        }
        val next = subNextPermutation(nums, start + 1)
        if (!next && nums[start] < nums[nums.size - 1]) {
            for (i in start + 1 until nums.size) {
                if (tmp < nums[i]) {
                    nums[start] = nums[i]
                    nums[i] = tmp
                    return true
                }
            }
        } else if (!next) {
            for (i in start until nums.size - 1) {
                nums[i] = nums[i + 1]
            }
            nums[nums.size - 1] = tmp
            return false
        }
        return true
    }

    fun solvePrint(nums: IntArray): Unit {
        nextPermutation(nums)
        println(nums.contentToString())
    }
}

fun main() {
    val sol = Solution2()
    sol.solvePrint(intArrayOf(1,2,3))
    sol.solvePrint(intArrayOf(3,2,1))
    sol.solvePrint(intArrayOf(2,3,1))
    sol.solvePrint(intArrayOf(1,1,5))
    sol.solvePrint(intArrayOf(3,2,1,4))
    sol.solvePrint(intArrayOf(4,3,2,1))
    sol.solvePrint(intArrayOf(1,1,2,2,5))
    sol.solvePrint(intArrayOf(1,1))
    sol.solvePrint(intArrayOf(1))
    sol.solvePrint(intArrayOf(2,1))
    sol.solvePrint(intArrayOf(1,2))
    sol.solvePrint(intArrayOf(1,3,2))
}