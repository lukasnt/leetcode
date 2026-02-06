package ugly_number

class Solution {
    fun isUgly(n: Int): Boolean {
        if (n <= 0) return false
        var rest = n
        while (rest % 2 == 0) {
            rest /= 2
        }
        while (rest % 3 == 0) {
            rest /= 3
        }
        while (rest % 5 == 0) {
            rest /= 5
        }
        return rest == 1
    }
}

fun main() {
    val sol = Solution()
    println(sol.isUgly(6))
    println(sol.isUgly(1))
    println(sol.isUgly(14))
    println(sol.isUgly(10))
    println(sol.isUgly(42))
    println(sol.isUgly(0))
    println(sol.isUgly(-6))
    println(sol.isUgly(-14))
}