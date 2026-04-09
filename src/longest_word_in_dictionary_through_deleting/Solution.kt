package longest_word_in_dictionary_through_deleting

class Solution {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        var longest = ""
        val indices = IntArray(dictionary.size) { 0 }
        for (c in s) {
            for (i in dictionary.indices) {
                val index = indices[i]
                val word = dictionary[i]
                if (index < word.length && word[index] == c) {
                    if (++indices[i] == word.length) {
                        longest = maxOf(longest, word,
                            Comparator.comparing<String, Int> { it.length }
                                .thenByDescending { it }
                        )
                    }
                }
            }
        }
        return longest
    }
}

fun main() {
    val sol = Solution()
    println(sol.findLongestWord("abpcplea", listOf("ale","apple","monkey","plea")))
    println(sol.findLongestWord("abpcplea", listOf("a","b","c")))
}