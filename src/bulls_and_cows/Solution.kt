package bulls_and_cows

class Solution {
    fun getHint(secret: String, guess: String): String {
        var bulls = 0
        val secretCounts: MutableMap<Char, Int> = HashMap()
        val guessCounts: MutableMap<Char, Int> = HashMap()
        for (i in 0 until secret.length) {
            if (secret[i] == guess[i]) {
                bulls++
            } else {
                secretCounts[secret[i]] = secretCounts.getOrDefault(secret[i], 0) + 1
                guessCounts[guess[i]] = guessCounts.getOrDefault(guess[i], 0) + 1
            }
        }
        val cows = secretCounts.keys.union(guessCounts.keys)
            .sumOf { minOf(secretCounts.getOrDefault(it, 0), guessCounts.getOrDefault(it, 0)) }
        return "${bulls}A${cows}B"
    }
}

fun main() {
    val sol = Solution()
    println(sol.getHint("1807", "7810"))
    println(sol.getHint("1123", "0111"))
    println(sol.getHint("1123134", "0111123"))
}