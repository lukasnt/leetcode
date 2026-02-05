package design_add_and_search_words_data_structure

class WordDictionary() {

    class TrieNode {
        val next: MutableMap<Char, TrieNode> = HashMap()
        var included: Boolean = false

        fun addWord(word: String, start: Int) {
            if (start == word.length) {
                included = true
                return
            }
            val node = next.getOrDefault(word[start], TrieNode())
            node.addWord(word, start + 1)
            if (next[word[start]] == null) {
                next[word[start]] = node
            }
        }

        fun search(word: String, start: Int): Boolean {
            if (start == word.length) return included
            if (word[start] == '.') {
                for (node in next.values) {
                    if (node.search(word, start + 1)) return true
                }
                return false
            } else {
                if (next[word[start]] != null) {
                    return next[word[start]]!!.search(word, start + 1)
                }
                return false
            }
        }

    }

    val root = TrieNode()

    fun addWord(word: String) {
        root.addWord(word, 0)
    }

    fun search(word: String): Boolean {
        return root.search(word, 0)
    }

}

fun main() {
    val wordDict = WordDictionary()
    wordDict.addWord("bad")
    wordDict.addWord("dad")
    wordDict.addWord("mad")
    println(wordDict.search("pad"))
    println(wordDict.search("bad"))
    println(wordDict.search(".ad"))
    println(wordDict.search("b.."))
    println(wordDict.search(".b."))
    println(wordDict.search("."))
    println(wordDict.search(".."))
    println(wordDict.search("..."))
}