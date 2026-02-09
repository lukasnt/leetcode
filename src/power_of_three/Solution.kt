package power_of_three

class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false
        var rest = n
        while (rest % 3 == 0) {
            rest /= 3
        }
        return rest == 1
    }
}

fun main() {
    val sol = Solution()
    println(sol.isPowerOfThree(27))
    println(sol.isPowerOfThree(9))
    println(sol.isPowerOfThree(3))
    println(sol.isPowerOfThree(4))
    println(sol.isPowerOfThree(0))
    println(sol.isPowerOfThree(-1))
}