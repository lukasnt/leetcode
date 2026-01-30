package factorial_trailing_zeroes

class Solution {
    fun trailingZeroes(n: Int): Int {
        var twos = 0
        var fives = 0
        for (num in 2 until n + 1) {
            var rest = num
            while (rest % 2 == 0) {
                twos++
                rest /= 2
            }
            while (rest % 5 == 0) {
                fives++
                rest /= 5
            }
        }
        return minOf(twos, fives)
    }
}

fun main() {
    val sol = Solution()
    println(sol.trailingZeroes(3))
    println(sol.trailingZeroes(5))
    println(sol.trailingZeroes(10))
    println(sol.trailingZeroes(100))
}