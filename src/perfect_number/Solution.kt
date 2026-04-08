package perfect_number

class Solution {
    fun checkPerfectNumber(num: Int): Boolean {
        val divisors = mutableListOf(1)
        var remaining = num
        var d = 2
        while (remaining > 1) {
            if (remaining % d == 0) {
                var divisor = d
                val newDivisors = ArrayList<Int>()
                while (remaining % d == 0) {
                    divisors.forEach { newDivisors.add(it * divisor) }
                    remaining /= d
                    divisor *= d
                }
                divisors.addAll(newDivisors)
            }
            d++
        }
        return divisors.sum() == 2 * num
    }
}

fun main() {
    val sol = Solution()
    println(sol.checkPerfectNumber(28))
    println(sol.checkPerfectNumber(6))
    println(sol.checkPerfectNumber(7))
    println(sol.checkPerfectNumber(8))
    println(sol.checkPerfectNumber(120))
    println(sol.checkPerfectNumber(1_000_000_000))
}