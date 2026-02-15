package bulb_switcher

import kotlin.math.sqrt

class Solution {
    fun bulbSwitch(n: Int): Int {
        if (n == 0) return 0
        val primes = LinkedHashSet<Long>()
        val primeList = ArrayList<Long>()
        primes.add(2)
        primeList.add(2)
        for (num in 3 until sqrt(n.toDouble()).toLong() + 1) {
            var found = true
            for (p in primes) {
                if (num % p == 0L) {
                    found = false
                    break
                }
            }
            if (found) {
                primes.add(num)
                primeList.add(num)
            }
        }
        val doublePrimePos = LongArray(primes.size) { 0 }
        val onBulbs = mutableListOf(1L)
        var last = 1L
        while (last <= n) {
            var next = Long.MAX_VALUE
            for (i in 0 until primes.size) {
                val prime = primeList[i]
                next = minOf(next, onBulbs[doublePrimePos[i].toInt()] * prime * prime)
            }
            for (i in 0 until primes.size) {
                val prime = primeList[i]
                if (next == onBulbs[doublePrimePos[i].toInt()] * prime * prime) doublePrimePos[i]++
            }
            if (next <= n) onBulbs.add(next)
            last = next
        }
        return onBulbs.size
    }
}

fun main() {
    val sol = Solution()
    println(sol.bulbSwitch(3))
    println(sol.bulbSwitch(0))
    println(sol.bulbSwitch(1))
    println(sol.bulbSwitch(4))
    println(sol.bulbSwitch(5))
    println(sol.bulbSwitch(9))
    println(sol.bulbSwitch(16))
    println(sol.bulbSwitch(25))
    println(sol.bulbSwitch(36))
    println(sol.bulbSwitch(1_000_000_000))
}