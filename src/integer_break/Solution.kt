package integer_break

class Solution {
    fun integerBreak(n: Int): Int {
        val sol = IntArray(n + 1) { 0 }
        sol[1] = 1
        for (num in 2 until n + 1) {
            for (sub in 1 until num) {
                sol[num] = maxOf(sol[num], sol[num - sub] * sub, (num - sub) * sub)
            }
        }
        return sol[n]
    }
}

fun main() {
    val sol = Solution()
    println(sol.integerBreak(2))
    println(sol.integerBreak(10))
    println(sol.integerBreak(11))
    println(sol.integerBreak(58))
}