package keyboard_row

class Solution {
    fun findWords(words: Array<String>): Array<String> {
        val row = IntArray(26) { 0 }
        "qwertyuiop".forEach { c -> row[c - 'a'] = 1 }
        "asdfghjkl".forEach  { c -> row[c - 'a'] = 2 }
        "zxcvbnm".forEach    { c -> row[c - 'a'] = 3 }
        val result = ArrayList<String>()
        for (word in words) {
            var first  = true
            var second = true
            var third  = true
            for (c in word.lowercase()) {
                first  = first  && row[c - 'a'] == 1
                second = second && row[c - 'a'] == 2
                third  = third  && row[c - 'a'] == 3
                if (!first && !second && !third) break
            }
            if (first || second || third) result.add(word)
        }
        return result.toTypedArray()
    }
}

fun main() {
    val sol = Solution()
    println(sol.findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")).contentToString())
    println(sol.findWords(arrayOf("omk")).contentToString())
    println(sol.findWords(arrayOf("adsdf","sfd")).contentToString())
}