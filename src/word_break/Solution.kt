package word_break

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val sol: BooleanArray = BooleanArray(s.length) { false }
        for (word in wordDict) {
            if (s.startsWith(word)) {
                sol[word.length - 1] = true
            }
        }
        for (i in 1 until s.length) {
            if (!sol[i - 1]) continue
            for (word in wordDict) {
                if (s.startsWith(word, i)) {
                    sol[i + word.length - 1] = true
                }
            }
        }
        return sol[s.length - 1]
    }
}

fun main() {
    val sol = Solution()
    println(sol.wordBreak("leetcode", listOf("leet","code")))
    println(sol.wordBreak("leetcode", listOf("leet","cod")))
    println(sol.wordBreak("applepenapple", listOf("apple","pen")))
    println(sol.wordBreak("pplepenapple", listOf("apple","pen")))
    println(sol.wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
    println(sol.wordBreak("catsanddog", listOf("cats","dog","sand","and","cat")))
    println(sol.wordBreak("a", listOf("a")))
    println(sol.wordBreak(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
    ))
    println(sol.wordBreak(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
        listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa", "b")
    ))
    println(sol.wordBreak("abcd", listOf("a","abc","b","cd")))
}