package add_digits

class Solution {
    fun addDigits(num: Int): Int {
        val sum = num.toString().map { c -> c - '0' }.sum()
        return if (sum < 10) sum else addDigits(sum)
    }
}

fun main() {
    val sol = Solution()
    println(sol.addDigits(38))
    println(sol.addDigits(0))
    println(sol.addDigits(99))
    println(sol.addDigits(999))
}