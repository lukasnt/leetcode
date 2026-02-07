package range_sum_query_immutable

class NumArray(nums: IntArray) {
    val nums = nums

    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        for (i in left..right) {
            sum += nums[i]
        }
        return sum
    }
}

fun main() {
    val numArray = NumArray(intArrayOf(-2,0,3,-5,2,-1))
    println(numArray.sumRange(0, 2))
    println(numArray.sumRange(2, 5))
    println(numArray.sumRange(0, 5))
}