package reverse_vowels_of_a_string

class Solution {
    fun reverseVowels(s: String): String {
        val vowels = "aeiouAEIOU".toSet()
        val found = ArrayList<Char>()
        for (c in s) {
            if (c in vowels) found.add(c)
        }
        val result = StringBuilder()
        var v = found.size - 1
        for (c in s) {
            if (c in vowels) result.append(found[v--])
            else result.append(c)
        }
        return result.toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.reverseVowels("IceCreAm"))
    println(sol.reverseVowels("leetcode"))
    println(sol.reverseVowels("ltcd"))
    println(sol.reverseVowels("abca"))
    println(sol.reverseVowels("a"))
    println(sol.reverseVowels("b"))
}