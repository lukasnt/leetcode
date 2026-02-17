package maximum_product_of_word_lengths

class Solution {
    fun maxProduct(words: Array<String>): Int {
        words.sortByDescending { it.length }
        val includes = Array(words.size) { BooleanArray(26) { false } }
        for (i in 0 until words.size) {
            for (c in words[i]) {
                includes[i][c - 'a'] = true
            }
        }
        var result = 0
        for (i in 0 until words.size) {
            for (j in i + 1 until words.size) {
                val prod = words[i].length * words[j].length
                if (prod < result) break
                var overlap = false
                for (k in 0 until 26) {
                    if (includes[i][k] && includes[j][k]) {
                        overlap = true
                        break
                    }
                }
                if (!overlap) result = maxOf(result, prod)
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.maxProduct(arrayOf("abcw","baz","foo","bar","xtfn","abcdef")))
    println(sol.maxProduct(arrayOf("a","ab","abc","d","cd","bcd","abcd")))
    println(sol.maxProduct(arrayOf("a","aa","aaa","aaaa")))
}