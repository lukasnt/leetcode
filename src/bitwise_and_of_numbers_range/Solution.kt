package bitwise_and_of_numbers_range

class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        val leftBits = left.toString(2).padStart(32, '0')
        val rightBits = right.toString(2).padStart(32, '0')
        val result = StringBuilder("0".repeat(32))
        for (i in 0 until 32) {
            if (leftBits[i] == '1' && rightBits[i] == '1') {
                result[i] = '1'
            } else if ((leftBits[i] == '1') xor (rightBits[i] == '1')) {
                break
            }
        }
        return result.toString().toInt(2)
    }
}

fun main() {
    val sol = Solution()
    println(sol.rangeBitwiseAnd(5, 7))
    println(sol.rangeBitwiseAnd(0, 0))
    println(sol.rangeBitwiseAnd(1, 2147483647))
    println(sol.rangeBitwiseAnd(7, 7))
    println(sol.rangeBitwiseAnd(6, 7))
    println(sol.rangeBitwiseAnd(416, 436))
}