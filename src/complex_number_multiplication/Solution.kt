package complex_number_multiplication

class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val (a, b) = toNumList(num1)
        val (c, d) = toNumList(num2)
        return "${a * c - b * d}+${a * d + b * c}i"
    }

    fun toNumList(complexNumber: String): List<Int> {
        return complexNumber
            .split("+")
            .map { num -> num.filter { c -> c != 'i' }.toInt() }
    }
}

fun main() {
    val sol = Solution()
    println(sol.complexNumberMultiply("1+1i", "1+1i"))
    println(sol.complexNumberMultiply("1+-1i", "1+-1i"))
}