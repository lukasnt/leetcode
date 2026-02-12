package power_of_four

class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        return n > 0 && n.toString(4).filter { it == '1' }.length == 1 && n.toString(4).filter { it != '0' }.length == 1
    }
}

fun main() {
    val sol = Solution()
    println(sol.isPowerOfFour(16))
    println(sol.isPowerOfFour(5))
    println(sol.isPowerOfFour(1))
    println(sol.isPowerOfFour(4))
    println(sol.isPowerOfFour(8))
    println(sol.isPowerOfFour(6))
}