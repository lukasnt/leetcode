package impelment_trie

class Trie() {

    class TrieNode {
        val letters: MutableMap<Char, TrieNode> = HashMap()
        var included: Boolean = false

        fun insert(word: String, start: Int) {
            if (start == word.length) {
                included = true
                return
            }
            if (letters[word[start]] != null) {
                letters[word[start]]!!.insert(word, start + 1)
            } else {
                val node = TrieNode()
                letters[word[start]] = node
                node.insert(word, start + 1)
            }
        }

        fun search(word: String, start: Int): Boolean {
            if (word.length == start) return included
            return letters[word[start]]?.search(word, start + 1) == true
        }

        fun startsWith(word: String, start: Int): Boolean {
            if (word.length == start) return true
            return letters[word[start]]?.startsWith(word, start + 1) == true
        }

    }

    val root: TrieNode = TrieNode()

    fun insert(word: String) {
        root.insert(word, 0)
    }

    fun search(word: String): Boolean {
        return root.search(word, 0)
    }

    fun startsWith(prefix: String): Boolean {
        return root.startsWith(prefix, 0)
    }
}

fun main() {
    val trie = Trie()
    trie.insert("apple")
    println(trie.search("apple"))
    println(trie.search("app"))
    println(trie.startsWith("app"))
    trie.insert("app")
    println(trie.search("app"))
    println(trie.search("appp"))
    println(trie.search("applee"))
    println(trie.startsWith("appl"))
    trie.insert("test")
    println(trie.startsWith("te"))
    println(trie.search("te"))
    println(trie.search("test"))
}
