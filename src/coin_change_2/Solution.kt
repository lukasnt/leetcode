package coin_change_2

class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val sol = Array(coins.size) { IntArray(amount + 1) { 0 } }
        for (num in 0..amount) {
            if (num % coins[0] == 0) sol[0][num] = 1
        }
        for (coinIndex in 1..<coins.size) {
            for (num in 0..amount) {
                val coin = coins[coinIndex]
                sol[coinIndex][num] += if (num - coin >= 0) sol[coinIndex][num - coin] else 0
                sol[coinIndex][num] += sol[coinIndex - 1][num]
            }
        }
        return sol[coins.size - 1][amount]
    }
}

fun main() {
    val sol = Solution()
    println(sol.change(5, intArrayOf(1,2,5)))
    println(sol.change(3, intArrayOf(2)))
    println(sol.change(10, intArrayOf(10)))
    println(sol.change(0, intArrayOf(1,2,5)))
}