package count_primes

class Solution {
    val primes = mutableListOf(2)

    fun countPrimes(n: Int): Int {
        val last = primes[primes.size - 1]
        for (num in last + 1 until n) {
            var found = true
            for (prime in primes) {
                if (num % prime == 0) {
                    found = false
                    break
                } else if (prime * prime > num) {
                    break
                }
            }
            if (found) primes.add(num)
        }
        return primes.filter { it < n }.size
    }
}

fun main() {
    val sol = Solution()
    println(sol.countPrimes(10))
    println(sol.countPrimes(0))
    println(sol.countPrimes(1))
    println(sol.countPrimes(1_000_000))
}