package elimination_game

class Solution {
    fun lastRemaining(n: Int): Int {
        var left = true
        var start = 1
        var length = n
        var jump = 1
        while (length > 1) {
            if (left || length % 2 == 1) {
                start += jump
            }
            jump *= 2
            length /= 2
            left = !left
        }
        return start
    }
}

fun main() {
    val sol = Solution()
    println(sol.lastRemaining(9))
    println(sol.lastRemaining(1))
    println(sol.lastRemaining(10))
    println(sol.lastRemaining(20))
    println(sol.lastRemaining(1_000_000_000))
    println(sol.lastRemaining(999_999_999))
}