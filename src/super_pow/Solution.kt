package super_pow

class Solution {
    fun superPow(a: Int, b: IntArray): Int {
        val leet = 1337
        val pow = IntArray(b.size + 1)
        pow[0] = a % leet
        var result = 1
        for (i in 1 until b.size + 1) {
            val digit = b[b.size - i]
            for (j in 0 until digit) {
                result = (result * pow[i - 1]) % leet
            }
            pow[i] = pow[i - 1]
            for (j in 1 until 10) {
                pow[i] = (pow[i] * pow[i - 1]) % leet
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.superPow(2, intArrayOf(3)))
    println(sol.superPow(2, intArrayOf(1,0)))
    println(sol.superPow(2, intArrayOf(1,1)))
    println(sol.superPow(1, intArrayOf(4,3,3,8,5,2)))
    println(sol.superPow(23, intArrayOf(4,3,3,8,5,2)))
}