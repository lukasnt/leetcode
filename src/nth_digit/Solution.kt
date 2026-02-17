package nth_digit

class Solution {
    fun findNthDigit(n: Int): Int {
        var rest = n.toLong() - 1
        var d = 1L
        var pow = 1L
        var skip = 9 * pow
        while (skip < n) {
            rest -= 9 * pow * d
            pow *= 10
            skip += 9 * pow * (++d)
        }
        val num = pow + rest / d
        val rem = rest % d
        return num.toString()[rem.toInt()] - '0'
    }
}

fun main() {
    val sol = Solution()
    println(sol.findNthDigit(3))
    println(sol.findNthDigit(11))
    println(sol.findNthDigit(10))
    println(sol.findNthDigit(190))
    println(sol.findNthDigit(191))
    println(sol.findNthDigit(2890))
    println(sol.findNthDigit(2891))
    println(sol.findNthDigit(39849823))
    println(sol.findNthDigit(189))
    println(sol.findNthDigit(1000000000))
}