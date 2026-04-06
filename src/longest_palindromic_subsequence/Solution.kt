package longest_palindromic_subsequence

class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        val sols = Array(n) { IntArray(n) { 0 } }
        sols[0][0] = 1
        for (i in 1 until n) {
            sols[i][i] = 1
            sols[i - 1][i] = if (s[i - 1] == s[i]) 2 else 1
        }
        for (length in 2 until n) {
            for (i in 0 until n - length) {
                if (s[i] == s[i + length]) {
                    sols[i][i + length] = sols[i + 1][i + length - 1] + 2
                } else {
                    sols[i][i + length] = maxOf(
                        sols[i + 1][i + length],
                        sols[i][i + length - 1]
                    )
                }
            }
        }
        return sols[0][n - 1]
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestPalindromeSubseq("bbbab"))
    println(sol.longestPalindromeSubseq("cbbd"))
    println(sol.longestPalindromeSubseq("c"))
    println(sol.longestPalindromeSubseq("cc"))
    println(sol.longestPalindromeSubseq("cb"))
    println(sol.longestPalindromeSubseq("ccc"))
}