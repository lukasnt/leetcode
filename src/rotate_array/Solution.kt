package rotate_array

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (k == 0) return
        val n = nums.size
        var current: Int
        var index = 0
        var shift = 0
        var temp = nums[index]
        for (i in 0 until n) {
            current = temp
            index = (index + k) % n
            temp = nums[index + shift]
            nums[index + shift] = current
            if (index % n == 0) {
                shift++
                temp = nums[(index + shift) % n]
            }
        }
    }

    fun solvePrint(nums: IntArray, k: Int) {
        rotate(nums, k)
        println(nums.contentToString())
    }

}

fun main() {
    val sol = Solution()
    sol.solvePrint(intArrayOf(1,2,3,4,5,6,7), 3)
    sol.solvePrint(intArrayOf(1,2,3,4,5,6,7), 7)
    sol.solvePrint(intArrayOf(-1,-100,3,99), 2)
    sol.solvePrint(intArrayOf(-1,-100,3,99,4,5,6,7), 6)
    sol.solvePrint(intArrayOf(-1,-100,3,99,4,5,6,7), 14)
    sol.solvePrint(intArrayOf(-1,-100,3,99,4,5,6,7), 4)
    sol.solvePrint(intArrayOf(-1,-100,3,99,4,5,6,7), 12)
    sol.solvePrint(intArrayOf(-1,-100,3,99,4,5,6,7), 0)
}