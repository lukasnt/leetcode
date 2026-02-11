package reverse_string

class Solution {
    fun reverseString(s: CharArray): Unit {
        for (i in 0 until s.size / 2) {
            val temp = s[i]
            s[i] = s[s.size - 1 - i]
            s[s.size - 1 - i] = temp
        }
    }

    fun solvePrint(s: CharArray) {
        reverseString(s)
        println(s.contentToString())
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrint(charArrayOf('h','e','l','l','o'))
    sol.solvePrint(charArrayOf('H','a','n','n','a','h'))
    sol.solvePrint(charArrayOf('H','a','n'))
    sol.solvePrint(charArrayOf('H','a'))
    sol.solvePrint(charArrayOf('H'))
}