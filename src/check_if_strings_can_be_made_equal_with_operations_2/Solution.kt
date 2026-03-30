package check_if_strings_can_be_made_equal_with_operations_2

class Solution {
    fun checkStrings(s1: String, s2: String): Boolean {
        val oddCount1  = IntArray(26) { 0 }
        val oddCount2  = IntArray(26) { 0 }
        val evenCount1 = IntArray(26) { 0 }
        val evenCount2 = IntArray(26) { 0 }
        for (i in s1.indices) {
            if (i % 2 == 0) {
                evenCount1[s1[i] - 'a']++
                evenCount2[s2[i] - 'a']++
            } else {
                oddCount1[s1[i] - 'a']++
                oddCount2[s2[i] - 'a']++
            }
        }
        return evenCount1.contentEquals(evenCount2) && oddCount1.contentEquals(oddCount2)
    }
}

fun main() {
    val sol = Solution()
    println(sol.checkStrings("abcdba", "cabdab"))
    println(sol.checkStrings("abe", "bea"))
}