package counting_bits

class Solution {
    fun countBits(n: Int): IntArray {
        if (n == 0) return intArrayOf(0)
        val sol = IntArray(n + 1)
        sol[0] = 0
        sol[1] = 1
        for (i in 2 until n + 1) {
            if (i % 2 == 0) {
                sol[i] = sol[i / 2]
            } else {
                sol[i] = sol[i - 1] + 1
            }
        }
        return sol
    }
}

fun main() {
    val sol = Solution()
    println(sol.countBits(2).contentToString())
    println(sol.countBits(5).contentToString())
    println(sol.countBits(10).contentToString())
    println(sol.countBits(0).contentToString())
    println(sol.countBits(1).contentToString())
}