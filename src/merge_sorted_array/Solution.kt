package merge_sorted_array

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = 0
        var j = 0
        var k = 0
        var s = 0
        var swapped = 0
        while (k < m + n) {
            val temp = nums1[k]
            if (s < swapped) {
                if ((j < n && nums2[j] < nums2[s]) || i >= m) {
                    nums1[k] = nums2[j]
                    if (k < m) {
                        nums2[swapped] = temp
                        swapped++
                    }
                    j++
                } else {
                    nums1[k] = nums2[s]
                    if (k < m) {
                        for (l in s until swapped - 1) {
                            nums2[l] = nums2[l + 1]
                        }
                        nums2[swapped - 1] = temp
                    } else {
                        s++
                    }
                    i++
                }
            } else {
                if ((j < n && nums2[j] < nums1[i]) || i >= m) {
                    nums1[k] = nums2[j]
                    j++
                    if (k < m) {
                        nums2[swapped] = temp
                        swapped++
                    }
                } else {
                    i++
                }
            }
            k++
        }
    }

    fun printSolve(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        merge(nums1, m, nums2, n)
        println(nums1.contentToString())
    }
}

fun main() {
    val sol = Solution()
    sol.printSolve(intArrayOf(1,2,3,0,0,0), 3, intArrayOf(2,5,6), 3)
    sol.printSolve(intArrayOf(0,0,0), 0, intArrayOf(2,5,6), 3)
    sol.printSolve(intArrayOf(6,7,8,0,0,0), 3, intArrayOf(2,5,6), 3)
    sol.printSolve(intArrayOf(6,7,8,0), 3, intArrayOf(2), 1)
    sol.printSolve(intArrayOf(6,7,8), 3, intArrayOf(), 0)
    sol.printSolve(intArrayOf(6,7,8), 3, intArrayOf(), 0)
    sol.printSolve(intArrayOf(6,7,8,0,0), 3, intArrayOf(1,2), 2)
    sol.printSolve(intArrayOf(6,7,0,0,0), 2, intArrayOf(1,2,10), 3)
    sol.printSolve(intArrayOf(-1,0,0,0,3,0,0,0,0,0,0), 5, intArrayOf(-1,-1,0,0,1,2), 6)
    sol.printSolve(
        intArrayOf(-10,-10,-9,-9,-9,-8,-8,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-2,-2,-1,-1,0,1,1,1,2,2,2,3,3,3,4,5,5,6,6,6,6,7,7,7,7,8,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        55,
        intArrayOf(-10,-10,-9,-9,-9,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-3,-3,-3,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,0,0,0,0,0,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,7,8,8,8,8,9,9,9,9),
        99
    )
}