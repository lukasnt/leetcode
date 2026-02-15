package ransom_note

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomNoteCount = HashMap<Char, Int>()
        for (c in ransomNote) {
            ransomNoteCount[c] = ransomNoteCount.getOrDefault(c, 0) + 1
        }
        val magazineCount = HashMap<Char, Int>()
        for (c in magazine) {
            magazineCount[c] = magazineCount.getOrDefault(c, 0) + 1
        }
        for (c in ransomNoteCount.keys) {
            if (magazineCount.getOrDefault(c, 0) < ransomNoteCount[c]!!) return false
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.canConstruct("a", "b"))
    println(sol.canConstruct("aa", "ab"))
    println(sol.canConstruct("aa", "aab"))
}