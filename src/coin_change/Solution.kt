package coin_change

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val sol = IntArray(amount + 1) { 0 }
        for (num in 1 until sol.size) {
            sol[num] = Int.MAX_VALUE
            for (coin in coins) {
                if (num - coin >= 0 && sol[num - coin] != -1) {
                    sol[num] = minOf(sol[num], sol[num - coin] + 1)
                }
            }
            if (sol[num] == Int.MAX_VALUE) sol[num] = -1
        }
        return sol[amount]
    }
}

fun main() {
    val sol = Solution()
    println(sol.coinChange(intArrayOf(1,2,5), 11))
    println(sol.coinChange(intArrayOf(2), 3))
    println(sol.coinChange(intArrayOf(1), 0))
}