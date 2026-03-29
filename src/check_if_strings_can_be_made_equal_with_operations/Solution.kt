package check_if_strings_can_be_made_equal_with_operations

class Solution {
    fun canBeEqual(s1: String, s2: String): Boolean {
        val n = s1.length
        val oddCount1 = IntArray(26) { 0 }
        val oddCount2 = IntArray(26) { 0 }
        val evenCount1 = IntArray(26) { 0 }
        val evenCount2 = IntArray(26) { 0 }
        for (i in 0 until n) {
            if (i % 2 == 0) {
                evenCount1[s1[i] - 'a']++
                evenCount2[s2[i] - 'a']++
            } else {
                oddCount1[s1[i] - 'a']++
                oddCount2[s2[i] - 'a']++
            }
        }
        return oddCount1.contentEquals(oddCount2) && evenCount1.contentEquals(evenCount2)
    }
}

fun main() {
    val sol = Solution()
    println(sol.canBeEqual("abcd", "cdab"))
    println(sol.canBeEqual("abcd", "dacb"))
}