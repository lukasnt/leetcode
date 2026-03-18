package hamming_distance

class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        return (x xor y).toString(2).count { it == '1'}
    }
}

fun main() {
    val sol = Solution()
    println(sol.hammingDistance(1, 4))
    println(sol.hammingDistance(3, 1))
    println(sol.hammingDistance(255, 0))
    println(sol.hammingDistance(255, 1))
    println(sol.hammingDistance(0, 0))
    println(sol.hammingDistance(1, 0))
    println(sol.hammingDistance(Int.MAX_VALUE, 0))
    println(sol.hammingDistance(Int.MAX_VALUE, 1))
}