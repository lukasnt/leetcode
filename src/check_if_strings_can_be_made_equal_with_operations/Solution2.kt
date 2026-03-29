package check_if_strings_can_be_made_equal_with_operations

class Solution2 {
    fun canBeEqual(s1: String, s2: String): Boolean {
        val odd  = (s1[1] == s2[1] && s1[3] == s2[3]) || (s1[1] == s2[3] && s1[3] == s2[1])
        val even = (s1[0] == s2[0] && s1[2] == s2[2]) || (s1[0] == s2[2] && s1[2] == s2[0])
        return odd && even
    }
}

fun main() {
    val sol = Solution2()
    println(sol.canBeEqual("abcd", "cdab"))
    println(sol.canBeEqual("abcd", "dacb"))
}