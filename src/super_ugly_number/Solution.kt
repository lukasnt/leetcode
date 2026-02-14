package super_ugly_number

class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val sol = IntArray(n)
        val primePos = IntArray(primes.size)
        sol[0] = 1
        for (i in 1 until n) {
            var next = Int.MAX_VALUE
            for (j in 0 until primePos.size) {
                val candidate = sol[primePos[j]] * primes[j]
                if (sol[i - 1] < candidate && candidate < next) {
                    next = candidate
                }
            }
            for (j in 0 until primePos.size) {
                if (sol[primePos[j]] * primes[j] == next) primePos[j]++
            }
            sol[i] = next
        }
        return sol[n - 1]
    }
}

fun main() {
    val sol = Solution()
    println(sol.nthSuperUglyNumber(12, intArrayOf(2,7,13,19)))
    println(sol.nthSuperUglyNumber(1, intArrayOf(2,7,13,19)))
    println(sol.nthSuperUglyNumber(115, intArrayOf(2,7,13,19)))
}