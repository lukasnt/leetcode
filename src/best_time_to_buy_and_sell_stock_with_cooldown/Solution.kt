package best_time_to_buy_and_sell_stock_with_cooldown

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        val sol = IntArray(n) { 0 }
        for (i in n - 2 downTo 0) {
            var best = sol[i + 1]
            for (k in i + 1 until n) {
                best = maxOf(best, prices[k] - prices[i] + if (k + 2 < n) sol[k + 2] else 0)
            }
            sol[i] = best
        }
        return sol[0]
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxProfit(intArrayOf(1,2,3,0,2)))
    println(sol.maxProfit(intArrayOf(1)))
    println(sol.maxProfit(intArrayOf(1,2)))
    println(sol.maxProfit(intArrayOf(2,1)))
    println(sol.maxProfit(intArrayOf(1,2,50,0,100,20)))
    println(sol.maxProfit(intArrayOf(100,2,0,50,1,2)))
}