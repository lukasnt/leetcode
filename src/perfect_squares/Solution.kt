package perfect_squares

class Solution {
    fun numSquares(n: Int): Int {
        val sol: IntArray = IntArray(n + 1) { 0 }
        sol[1] = 1
        for (num in 2 until n + 1) {
            var min = Int.MAX_VALUE
            var sqrt = 1
            while (sqrt * sqrt <= num) {
                if (sol[num - sqrt * sqrt] + 1 < min) {
                    min = sol[num - sqrt * sqrt] + 1
                }
                sqrt++
            }
            sol[num] = min
        }
        return sol[n]
    }
}

fun main() {
    val sol = Solution()
    println(sol.numSquares(12))
    println(sol.numSquares(13))
    println(sol.numSquares(16))
    println(sol.numSquares(25))
    println(sol.numSquares(1))
    println(sol.numSquares(10_000))
    println(sol.numSquares(9_999))
}