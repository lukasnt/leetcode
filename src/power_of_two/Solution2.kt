package power_of_two

class Solution2 {
    val powers: MutableSet<Long> = mutableSetOf(1, 2)
    var next: Long = 4

    fun isPowerOfTwo(n: Int): Boolean {
        while (n >= next) {
            powers.add(next)
            next *= 2
        }
        return powers.contains(n.toLong())
    }
}

fun main() {
    val sol = Solution2()
    println(sol.isPowerOfTwo(1))
    println(sol.isPowerOfTwo(16))
    println(sol.isPowerOfTwo(8))
    println(sol.isPowerOfTwo(3))
    println(sol.isPowerOfTwo(4))
    println(sol.isPowerOfTwo(-4))
    println(sol.isPowerOfTwo(1073741824))
}