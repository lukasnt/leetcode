package shuffle_an_array

import kotlin.random.Random

class Solution(val nums: IntArray) {

    val shuffled = nums.copyOf()

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        var shifted = 0
        for (i in 0 until shuffled.size) {
            val index = shifted + Random.nextInt(0, shuffled.size - shifted)
            val temp = shuffled[index]
            shuffled[index] = shuffled[shifted]
            shuffled[shifted++] = temp
        }
        return shuffled
    }

}

fun main() {
    var sol = Solution(intArrayOf(1,2,3))
    println(sol.shuffle().contentToString())
    println(sol.shuffle().contentToString())
    println(sol.shuffle().contentToString())
    println(sol.reset().contentToString())
    sol = Solution(intArrayOf(1))
    println(sol.shuffle().contentToString())
    println(sol.reset().contentToString())
    sol = Solution(intArrayOf(1,2,3,4,5,6,7,8,9,10))
    println(sol.shuffle().contentToString())
    println(sol.reset().contentToString())
    println(sol.shuffle().contentToString())
    println(sol.reset().contentToString())
}
