package intersection_of_two_arrays_2

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val m = nums1.size
        val n = nums2.size
        val table = IntArray(nums1.size) { -1 }
        for (num in nums1) {
            val hash = num % m
            for (i in 0 until m) {
                val next = (hash + i) % m
                if (table[next] == -1) {
                    table[next] = num
                    break
                }
            }
        }
        val temp = IntArray(m + n)
        var len = 0
        for (num in nums2) {
            val hash = num % m
            if (table[hash] != -1) {
                for (i in 0 until m) {
                    val next = (hash + i) % m
                    if (table[next] == num) {
                        temp[len++] = num
                        table[next] = -2
                        break
                    } else if (table[next] == -1) {
                        break
                    }
                }
            }
        }
        return temp.copyOfRange(0, len)
    }
}

fun main() {
    val sol = Solution()
    println(sol.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentToString())
    println(sol.intersect(intArrayOf(1, 2, 1), intArrayOf(2, 2)).contentToString())
    println(sol.intersect(intArrayOf(1, 2, 1, 3, 5, 5), intArrayOf(5, 5, 3, 2, 2, 3)).contentToString())
    println(sol.intersect(intArrayOf(1), intArrayOf(1)).contentToString())
}