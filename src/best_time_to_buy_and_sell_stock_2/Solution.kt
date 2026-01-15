package best_time_to_buy_and_sell_stock_2

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var prev = prices[0]
        for (i in 1 until prices.size) {
            if (prices[i] > prev) {
                profit += prices[i] - prev
            }
            prev = prices[i]
        }
        return profit
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(sol.maxProfit(intArrayOf(1,2,3,4,5)))
    println(sol.maxProfit(intArrayOf(7,6,4,3,1)))
}