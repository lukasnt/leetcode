package number_complement

class Solution {
    fun findComplement(num: Int): Int {
        var pow = 1L
        while (pow <= num) {
            pow *= 2
        }
        return (pow - num - 1).toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.findComplement(5))
    println(sol.findComplement(1))
    println(sol.findComplement(10))
    println(sol.findComplement(8))
    println(sol.findComplement(16))
    println(sol.findComplement(15))
    println(sol.findComplement(2147483647))
}