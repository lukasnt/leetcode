package number_of_1_bits

class Solution {
    fun hammingWeight(n: Int): Int {
        return n.toString(2).count { it == '1' }
    }
}

fun main() {
    val sol = Solution()
    println(sol.hammingWeight(11))
    println(sol.hammingWeight(128))
    println(sol.hammingWeight(2147483645))
    println(sol.hammingWeight(1))
}