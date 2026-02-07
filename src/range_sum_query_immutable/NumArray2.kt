package range_sum_query_immutable

class NumArray2(nums: IntArray) {
    val nums = nums
    val cumulative: IntArray = IntArray(nums.size)

    init {
        cumulative[0] = nums[0]
        for (i in 1 until nums.size) {
            cumulative[i] = cumulative[i - 1] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return cumulative[right] - cumulative[left] + nums[left]
    }
}

fun main() {
    val numArray = NumArray2(intArrayOf(-2,0,3,-5,2,-1))
    println(numArray.sumRange(0, 2))
    println(numArray.sumRange(2, 5))
    println(numArray.sumRange(0, 5))
}