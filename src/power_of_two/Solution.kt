package power_of_two

class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0) return false
        if (n == 1) return true
        return if (n % 2 == 0) isPowerOfTwo(n / 2) else false
    }
}

fun main() {
    val sol = Solution()
    println(sol.isPowerOfTwo(1))
    println(sol.isPowerOfTwo(16))
    println(sol.isPowerOfTwo(3))
    println(sol.isPowerOfTwo(4))
    println(sol.isPowerOfTwo(-4))
}