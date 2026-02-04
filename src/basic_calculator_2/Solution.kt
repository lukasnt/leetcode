package basic_calculator_2

class Solution {
    fun calculate(s: String): Int {
        val terms = s.trim().split("+", "-")
        val ops = s.filter { it == '+' || it == '-' }
        val prods = terms.map { term ->
            val nums = term.split("*", "/")
            var prod = if (nums.isNotEmpty()) nums[0].trim().toInt() else 0
            val ops = term.filter { it == '*' || it == '/' }
            for (i in 0 until ops.length) {
                when (ops[i]) {
                    '*' -> prod *= nums[i + 1].trim().toInt()
                    '/' -> prod /= nums[i + 1].trim().toInt()
                }
            }
            prod
        }
        var sum = if (prods.isNotEmpty()) prods[0] else 0
        for (i in 0 until ops.length) {
            when (ops[i]) {
                '+' -> sum += prods[i + 1]
                '-' -> sum -= prods[i + 1]
            }
        }
        return sum
    }
}

fun main() {
    val sol = Solution()
    println(sol.calculate("3+2*2"))
    println(sol.calculate(" 3/2 "))
    println(sol.calculate(" 3+5 / 2 "))
    println(sol.calculate(" 3  +  5 * 2 / 2 "))
    println(sol.calculate(" 3  +  5 * 3 / 2 "))
    println(sol.calculate("14/3*2"))
}