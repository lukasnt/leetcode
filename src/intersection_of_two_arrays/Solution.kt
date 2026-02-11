package intersection_of_two_arrays

class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val m = nums1.size
        val n = nums2.size
        val table = IntArray(m) { -1 }
        for (num in nums1) {
            val hash = num % m
            if (table[hash] == -1) {
                table[hash] = num
            } else {
                for (i in 0 until m) {
                    val next = (hash + i) % m
                    if (table[next] == -1) {
                        table[next] = num
                        break
                    } else if (table[next] == num) {
                        break
                    }
                }
            }
        }
        var len = 0
        val temp = IntArray(n)
        for (num in nums2) {
            val hash = num % m
            if (table[hash] != -1) {
                if (table[hash] == num) {
                    temp[len++] = num
                    table[hash] = -2
                } else {
                    for (i in 1 until m) {
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
        }
        return temp.copyOfRange(0, len)
    }
}

fun main() {
    val sol = Solution()
    println(sol.intersection(intArrayOf(1,2,2,1), intArrayOf(2,2)).contentToString())
    println(sol.intersection(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).contentToString())
    println(sol.intersection(intArrayOf(1,2,3,4,5,6,7,8,9,10), intArrayOf(20,7)).contentToString())
    println(sol.intersection(intArrayOf(1,2,3,4,5,6,7,8,9,10), intArrayOf(20,11,30)).contentToString())
    println(sol.intersection(intArrayOf(9,1), intArrayOf(7,8,3,9,0,0,9,1,5)).contentToString())
}