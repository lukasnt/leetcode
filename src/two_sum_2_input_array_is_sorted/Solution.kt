package two_sum_2_input_array_is_sorted

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1
        var twoSum = numbers[i] + numbers[j]
        while (twoSum != target) {
            if (twoSum < target) {
                i++
            } else {
                j--
            }
            if (i != j) {
                twoSum = numbers[i] + numbers[j]
            }
        }
        return intArrayOf(i + 1, j + 1)
    }

    fun printArray(result: IntArray) {
        println(result.contentToString())
    }
}

fun main() {
    val sol = Solution()
    sol.printArray(sol.twoSum(intArrayOf(2,7,11,15), 9))
    sol.printArray(sol.twoSum(intArrayOf(2,3,4), 6))
    sol.printArray(sol.twoSum(intArrayOf(-1,0), -1))
    sol.printArray(sol.twoSum(intArrayOf(-1,1), 0))
    sol.printArray(sol.twoSum(intArrayOf(-1,1,2), 3))
    sol.printArray(sol.twoSum(intArrayOf(-1,1,50,1000), 999))
    sol.printArray(sol.twoSum(intArrayOf(5,25,75), 100))
    sol.printArray(sol.twoSum(intArrayOf(5,20,25,74,80,100,200,300), 125))
}