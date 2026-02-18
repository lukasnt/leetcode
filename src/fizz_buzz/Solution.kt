package fizz_buzz

class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val result = ArrayList<String>(n)
        for (num in 1 until n + 1) {
            if (num % 3 == 0 && num % 5 == 0) {
                result.add("FizzBuzz")
            } else if (num % 3 == 0) {
                result.add("Fizz")
            } else if (num % 5 == 0) {
                result.add("Buzz")
            } else {
                result.add(num.toString())
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.fizzBuzz(3))
    println(sol.fizzBuzz(5))
    println(sol.fizzBuzz(15))
    println(sol.fizzBuzz(1))
    println(sol.fizzBuzz(10_000))
}