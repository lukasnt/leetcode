package maximum_amount_of_money_robot_can_earn

class Solution {
    val minValue = 2 * 500 * -1000

    fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size
        val zeroSpecial = Array(m) { IntArray(n) { minValue } }
        val oneSpecial  = Array(m) { IntArray(n) { minValue } }
        val twoSpecial  = Array(m) { IntArray(n) { minValue } }
        zeroSpecial[m - 1][n - 1] = coins[m - 1][n - 1]
        oneSpecial [m - 1][n - 1] = maxOf(coins[m - 1][n - 1], 0)
        twoSpecial [m - 1][n - 1] = maxOf(coins[m - 1][n - 1], oneSpecial[m - 1][n - 1])
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (i == m - 1 && j == n - 1) continue
                zeroSpecial[i][j] = coins[i][j] + maxOf(
                    getAmount(zeroSpecial, i + 1, j),
                    getAmount(zeroSpecial, i, j + 1)
                )
                oneSpecial[i][j] = maxOf(
                    coins[i][j] + maxOf(
                        getAmount(oneSpecial, i + 1, j),
                        getAmount(oneSpecial, i, j + 1)
                    ),
                    maxOf(
                        getAmount(zeroSpecial, i + 1, j),
                        getAmount(zeroSpecial, i, j + 1)
                    )
                )
                twoSpecial[i][j] = maxOf(
                    coins[i][j] + maxOf(
                        getAmount(twoSpecial, i + 1, j),
                        getAmount(twoSpecial, i, j + 1)
                    ),
                    maxOf(
                        getAmount(oneSpecial, i + 1, j),
                        getAmount(oneSpecial, i, j + 1)
                    )
                )
            }
        }
        twoSpecial.forEach { println(it.contentToString()) }
        oneSpecial.forEach { println(it.contentToString()) }
        zeroSpecial.forEach { println(it.contentToString()) }
        return twoSpecial[0][0]
    }

    private fun getAmount(amounts: Array<IntArray>, row: Int, col: Int): Int {
        return if (row in amounts.indices && col in amounts[row].indices) amounts[row][col] else minValue
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumAmount(arrayOf(
        intArrayOf(0,1,-1),
        intArrayOf(1,-2,3),
        intArrayOf(2,-3,4),
    )))
    println(sol.maximumAmount(arrayOf(
        intArrayOf(10,10,10),
        intArrayOf(10,10,10)
    )))
    println(sol.maximumAmount(arrayOf(
        intArrayOf(10,-10,-10)
    )))
    println(sol.maximumAmount(arrayOf(
        intArrayOf(10,-10,-10,-10,-10)
    )))
}