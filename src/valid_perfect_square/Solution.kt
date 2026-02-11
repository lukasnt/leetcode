package valid_perfect_square

class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true
        var sqrt: Long = 2
        while (sqrt * sqrt < num) {
            if ((sqrt + sqrt) * (sqrt + sqrt) <= num) sqrt += sqrt
            else sqrt++
        }
        return sqrt * sqrt == num.toLong()
    }
}

fun main() {
    val sol = Solution()
    println(sol.isPerfectSquare(4))
    println(sol.isPerfectSquare(9))
    println(sol.isPerfectSquare(16))
    println(sol.isPerfectSquare(14))
    println(sol.isPerfectSquare(65_536))
    println(sol.isPerfectSquare(2000105819))
}