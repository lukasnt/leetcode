package verify_preorder_serialization_of_a_binary_tree

class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        var nulls = 1
        val nodes = preorder.split(",")
        for (value in nodes) {
            if (nulls <= 0) return false
            if (value == "#") {
                nulls--
            } else {
                nulls++
            }
        }
        return nulls == 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
    println(sol.isValidSerialization("1,#"))
    println(sol.isValidSerialization("9,#,#,1"))
    println(sol.isValidSerialization("9,#,#,1,#"))
    println(sol.isValidSerialization("9,#,1,#"))
    println(sol.isValidSerialization("9,#,1,#,#"))
}