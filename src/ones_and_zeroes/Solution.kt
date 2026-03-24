package ones_and_zeroes

class Solution {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val sols = Array(strs.size) { Array(m + 1) { IntArray(n + 1) { 0 } } }
        val zeroes = strs[0].count { it == '0' }
        val ones = strs[0].length - zeroes
        for (i in 0..m) {
            for (j in 0..n) {
                sols[0][i][j] = if (i >= zeroes && j >= ones) 1 else 0
            }
        }
        for (k in 1 until sols.size) {
            val zeroes = strs[k].count { it == '0' }
            val ones = strs[k].length - zeroes
            for (i in 0..m) {
                for (j in 0..n) {
                    if (i >= zeroes && j >= ones) {
                        sols[k][i][j] = sols[k - 1][i - zeroes][j - ones] + 1
                    }
                    sols[k][i][j] = maxOf(sols[k][i][j], sols[k - 1][i][j])
                }
            }
        }
        return sols[sols.size - 1][m][n]
    }
}

fun main() {
    val sol = Solution()
    println(sol.findMaxForm(arrayOf("10", "0001", "111001", "1", "0"), 5, 3))
}