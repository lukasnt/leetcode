package integer_replacement

class Solution {
    fun integerReplacement(n: Int): Int {
        return integerReplacement(n, HashMap())
    }

    private fun integerReplacement(n: Int, memo: MutableMap<Int, Int>): Int {
        if (n == 1) return 0
        if (memo.containsKey(n)) return memo[n]!!
        val result = if (n % 2 == 0) {
            integerReplacement(n / 2, memo) + 1
        } else {
            2 + minOf(
                integerReplacement((n - 1) / 2, memo),
                if (n != Int.MAX_VALUE) integerReplacement((n + 1) / 2, memo) else 30
            )
        }
        memo[n] = result
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.integerReplacement(8))
    println(sol.integerReplacement(7))
    println(sol.integerReplacement(4))
    println(sol.integerReplacement(Int.MAX_VALUE - 1))
    println(sol.integerReplacement(Int.MAX_VALUE))
}