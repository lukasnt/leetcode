package reverse_bits

class Solution {
    fun reverseBits(n: Int): Int {
        return n.toString(2)
            .padStart(32, '0')
            .reversed()
            .toInt(2)
    }
}

fun main() {
    val sol = Solution()
    println(sol.reverseBits(43261596))
    println(sol.reverseBits(2147483644))
    println(sol.reverseBits(2))
    println(sol.reverseBits(0))
}