package happy_number

class Solution {
    fun isHappy(n: Int): Boolean {
        val nums = mutableSetOf<Int>()
        var next = n
        while (next != 1) {
            nums.add(next)
            val digits = next.toString(10)
            next = 0
            for (d in digits) {
                next += (d - '0') * (d - '0')
            }
            if (nums.contains(next)) return false
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.isHappy(19))
    println(sol.isHappy(82))
    println(sol.isHappy(68))
    println(sol.isHappy(100))
    println(sol.isHappy(2))
    println(sol.isHappy(24))
}
