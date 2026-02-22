package regular_expression_matching

class Solution2 {
    fun isMatch(s: String, p: String): Boolean {
        return isMatch(s, 0, p, 0, Array(s.length + 1) { Array(p.length + 1) { null } })
    }

    private fun isMatch(s: String, sIndex: Int, p: String, pIndex: Int, memo: Array<Array<Boolean?>>): Boolean {
        if (sIndex >= s.length && pIndex >= p.length) return true
        if (memo[sIndex][pIndex] != null) return memo[sIndex][pIndex]!!
        val sNext = sIndex + 1
        val pNext = pIndex + 1
        if (sIndex < s.length && pIndex < p.length) {
            val sChar = s[sIndex]
            val pChar = p[pIndex]
            if (sChar == pChar || pChar == '.') {
                if (pNext < p.length && p[pNext] == '*') {
                    if (isMatch(s, sNext, p, pIndex, memo)) return memoResult(true, sIndex, pIndex, memo)
                    if (isMatch(s, sNext, p, pNext + 1, memo)) return memoResult(true, sIndex, pIndex, memo)
                }
                else if (isMatch(s, sNext, p, pNext, memo)) return memoResult(true, sIndex, pIndex, memo)
            }
        }
        if (pNext < p.length && p[pNext] == '*') {
            if (isMatch(s, sIndex, p, pNext + 1, memo)) return memoResult(true, sIndex, pIndex, memo)
        }
        return memoResult(false, sIndex, pIndex, memo)
    }

    private fun memoResult(result: Boolean, sIndex: Int, pIndex: Int, memo: Array<Array<Boolean?>>): Boolean {
        memo[sIndex][pIndex] = result
        return result
    }
}

fun main() {
    val sol = Solution2()
    println(!sol.isMatch("aa", "a"))
    println(sol.isMatch("aa", "aa"))
    println(sol.isMatch("aa", "a*"))
    println(sol.isMatch("ab", ".*"))
    println(sol.isMatch("abkdjfhskjfhjskh", ".*"))
    println(sol.isMatch("abkdjfhskjfhjskh", "abk.*kh"))
    println(!sol.isMatch("abkdjfhskjfhjskh", "abd.*kh"))
    println(sol.isMatch("aaaaa", "a*"))
    println(!sol.isMatch("aaaaa", "a*b"))
    println(sol.isMatch("aaaab", "a*b"))
    println(sol.isMatch("aaaab", ".*b"))
    println(sol.isMatch("aaaab", "a*."))
    println(!sol.isMatch("abc", "a*."))
    println(sol.isMatch("abc", "abc"))
    println(sol.isMatch("abc", "abc*"))
    println(sol.isMatch("aaaaabbbcccc", "a*b*c*."))
    println(!sol.isMatch("aaaaabbbcc", "a*b*c"))
    println(sol.isMatch("aaaaabbbcc", "a*b*.c"))
    println(!sol.isMatch("a", ".."))
    println(sol.isMatch("a", ".*"))
    println(sol.isMatch("a", "..*"))
    println(sol.isMatch("aab", "c*a*b"))
    println(sol.isMatch("a", "ab*"))
    println(sol.isMatch("a", "ab*c*d*e*f*"))
    println(sol.isMatch("abkdjfhskjfhjskhb", "b*c*abkb*c*.*b*c*khb*c*"))
    println(!sol.isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*"))
    println(sol.isMatch("aaaaaaaaaaaaaaaaaaaa", "a*a*a*a*a*a*a*a*a*a*"))
    println(sol.isMatch("", "a*a*a*a*a*a*a*a*a*a*"))
}