package edit_distance


class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        if (m == 0) return n
        if (n == 0) return m
        val sol: Array<Array<Int>> = Array(m) { Array(n) { 0 } }
        sol[0][0] = if (word1[0] == word2[0]) 0 else 1
        for (j in 1 until n) {
            if (word1[0] == word2[j]) {
                sol[0][j] = j
            } else {
                sol[0][j] = sol[0][j - 1] + 1
            }
        }
        for (i in 1 until m) {
            if (word1[i] == word2[0]) {
                sol[i][0] = i
            } else {
                sol[i][0] = sol[i - 1][0] + 1
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (word1[i] == word2[j]) {
                    sol[i][j] = minOf(sol[i - 1][j - 1] + 0, sol[i - 1][j] + 1, sol[i][j - 1] + 1)
                } else {
                    sol[i][j] = minOf(sol[i - 1][j - 1] + 1, sol[i - 1][j] + 1, sol[i][j - 1] + 1)
                }
            }
        }
        return sol[m - 1][n - 1]
    }
}

fun main() {
    val sol = Solution()
    println(sol.minDistance("horse", "ros"))
    println(sol.minDistance("intention", "execution"))
    println(sol.minDistance("", ""))
    println(sol.minDistance("abc", ""))
    println(sol.minDistance("", "1234"))
    println(sol.minDistance("abc", "1234"))
}