package range_sum_query_mutable

class NumArray(val nums: IntArray) {

    fun update(index: Int, `val`: Int) {
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        var result = 0
        for (i in left until right + 1) {
            result += nums[i]
        }
        return result
    }

}

fun main() {
    val numArray = NumArray(intArrayOf(1,3,5))
    println(numArray.sumRange(0, 2))
    numArray.update(1, 2)
    println(numArray.sumRange(0, 2))
}

