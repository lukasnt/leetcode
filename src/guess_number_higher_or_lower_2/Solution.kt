package guess_number_higher_or_lower_2

class Solution {
    fun getMoneyAmount(n: Int): Int {
        val sol = Array (n + 1) { IntArray(n + 1) { 0 } }
        for (i in 1 until n + 1) {
            for (j in i - 1 downTo 1) {
                sol[j][i] = Int.MAX_VALUE
                for (k in j until i) {
                    sol[j][i] = minOf(sol[j][i], k + maxOf(sol[j][k - 1], sol[k + 1][i]))
                }
            }
        }
        return sol[1][n]
    }
}

fun main() {
    val sol = Solution()
    println(sol.getMoneyAmount(10))
    println(sol.getMoneyAmount(1))
    println(sol.getMoneyAmount(2))
    println(sol.getMoneyAmount(3))
    println(sol.getMoneyAmount(4))
}