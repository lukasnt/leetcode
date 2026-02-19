package has_alternating_bits

class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        var a = 1L
        var b = 2L
        while (a <= n) {
            if (n == a.toInt() || n == b.toInt()) return true
            a = (a shl 2) + 1
            b = (b shl 2) + 2
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.hasAlternatingBits(5))
    println(sol.hasAlternatingBits(7))
    println(sol.hasAlternatingBits(11))
    println(sol.hasAlternatingBits(0x55))
    println(sol.hasAlternatingBits(0x2))
    println(sol.hasAlternatingBits(4))
    println(sol.hasAlternatingBits(1431655766))
}