package repeated_dna_sequences

import kotlin.math.pow

class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) return emptyList()
        val result: MutableSet<String> = HashSet()
        val seen: MutableSet<Int> = HashSet()
        val highest = 5.0.pow(9).toInt()
        var current = s.substring(0 until 10)
            .replace("A", "1")
            .replace("C", "2")
            .replace("T", "3")
            .replace("G", "4")
            .toInt(5)
        seen.add(current)
        for (i in 1 until s.length - 9) {
            current -= letterValue(s[i - 1]) * highest
            current *= 5
            current += letterValue(s[i + 9])
            if (seen.contains(current)) {
                result.add(current.toString(5)
                    .replace("1", "A")
                    .replace("2", "C")
                    .replace("3", "T")
                    .replace("4", "G")
                    .padStart(10, 'A')
                )
            } else {
                seen.add(current)
            }
        }
        return result.toList()
    }

    fun letterValue(c: Char): Int {
        return when (c) {
            'A' -> 1
            'C' -> 2
            'T' -> 3
            'G' -> 4
            else -> -1
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
    println(sol.findRepeatedDnaSequences("AAAAAAAAAAAAA"))
    println(sol.findRepeatedDnaSequences("A"))
}