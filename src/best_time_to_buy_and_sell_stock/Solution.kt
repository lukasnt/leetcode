package best_time_to_buy_and_sell_stock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minDay = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - minDay
            if (profit > maxProfit) {
                maxProfit = profit
            }
            if (prices[i] < minDay) {
                minDay = prices[i]
            }
        }
        return maxProfit
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(sol.maxProfit(intArrayOf(7,6,4,3,1)))
    println(sol.maxProfit(intArrayOf(7)))
    println(sol.maxProfit(intArrayOf(7,1,50,5,3,6,4,51)))
}