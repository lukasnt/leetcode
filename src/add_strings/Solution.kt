package add_strings

class Solution {
    fun addStrings(num1: String, num2: String): String {
        val table = createTable()
        val result = StringBuilder()
        val m = num1.length
        val n = num2.length
        val length = maxOf(m, n)
        var carry = false
        for (i in 0 until length) {
            val a = if (i < m) num1[m - i - 1] else '0'
            val b = if (i < n) num2[n - i - 1] else '0'
            var (v, c) = table[a.code][b.code]
            if (carry) {
                c = c || table[v.code]['1'.code].second
                v = table[v.code]['1'.code].first
            }
            result.append(v)
            carry = c
        }
        if (carry) result.append('1')
        return result.reverse().toString()
    }

    fun createTable(): Array<Array<Pair<Char, Boolean>>> {
        val zero = '0'.code
        return Array(zero + 10) { i ->
            Array(zero + 10) { j ->
                val a = i - zero
                val b = j - zero
                if (a + b >= 0) {
                    '0' + (a + b) % 10 to (a + b >= 10)
                } else {
                    '0' to false
                }
            }
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.addStrings("1234", "1234"))
    println(sol.addStrings("1299", "1299"))
    println(sol.addStrings("8299", "2299"))
    println(sol.addStrings("8299", "299"))
    println(sol.addStrings("8299", "0"))
    println(sol.addStrings("8299", "999999"))
    println(sol.addStrings("999999", "999"))
}