package repeated_dna_sequences

class Solution2 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) return emptyList()
        val result: MutableSet<String> = HashSet()
        val seen: MutableSet<String> = HashSet()
        val current = StringBuilder(s.substring(0 until 10))
        seen.add(current.toString())
        for (i in 1 until s.length - 9) {
            current.deleteCharAt(0)
            current.append(s[i + 9])
            if (seen.contains(current.toString())) {
                result.add(current.toString())
            } else {
                seen.add(current.toString())
            }
        }
        return result.toList()
    }
}

fun main() {
    val sol = Solution2()
    println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
    println(sol.findRepeatedDnaSequences("AAAAAAAAAAAAA"))
    println(sol.findRepeatedDnaSequences("A"))
}