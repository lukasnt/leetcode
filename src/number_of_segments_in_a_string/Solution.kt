package number_of_segments_in_a_string

class Solution {
    fun countSegments(s: String): Int {
        return s.split(" ").count { it.isNotEmpty() }
    }
}

fun main() {
    val sol = Solution()
    println(sol.countSegments("Hello, my name is John"))
    println(sol.countSegments("Hello"))
    println(sol.countSegments("Hello   , my name  is   John"))
}