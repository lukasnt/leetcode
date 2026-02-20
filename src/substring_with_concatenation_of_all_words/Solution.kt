package substring_with_concatenation_of_all_words

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordCount = HashMap<String, Int>()
        for (word in words) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
        val len = words[0].length
        val sequence = IntArray(s.length) { 0 }
        for (i in 0 until s.length) {
            if (i + len <= s.length) {
                val word = s.substring(i, i + len)
                if (wordCount.containsKey(word)) {
                    sequence[i] = if (i >= len) sequence[i - len] + 1 else 1
                }
                if (sequence[i] >= words.size) {
                    val remaining = wordCount.clone() as HashMap<String, Int>
                    remaining[word] = remaining[word]!! - 1
                    for (j in 1 until words.size) {
                        val index = i - j * len
                        val current = s.substring(index, index + len)
                        if (remaining.containsKey(current) && remaining[current]!! > 0) {
                            remaining[current] = remaining[current]!! - 1
                        } else {
                            sequence[i] = j
                            break
                        }
                    }
                }
            }
        }
        val result = ArrayList<Int>()
        for (i in 0 until sequence.size) {
            if (sequence[i] >= words.size) result.add(i - (words.size - 1) * len)
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findSubstring("barfoothefoobarman", arrayOf("foo", "bar")))
    println(sol.findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")))
    println(sol.findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the")))
    println(sol.findSubstring("barbar", arrayOf("bar")))
    println(sol.findSubstring("barbarbarbarbarbarbar", arrayOf("bar", "rab", "rba")))
    println(sol.findSubstring("ba", arrayOf("b", "a")))
    println(sol.findSubstring("b", arrayOf("b")))
    println(sol.findSubstring("a", arrayOf("b")))
}