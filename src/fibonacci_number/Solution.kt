package fibonacci_number

class Solution {
    fun fib(n: Int): Int {
        var fn1 = 0
        var fn  = 1
        (2..n).forEach { _ ->
            val temp = fn
            fn += fn1
            fn1 = temp
        }
        return if (n != 0) fn else 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.fib(0))
    println(sol.fib(1))
    println(sol.fib(2))
    println(sol.fib(3))
    println(sol.fib(4))
    println(sol.fib(5))
    println(sol.fib(6))
    println(sol.fib(7))
    println(sol.fib(30))
}