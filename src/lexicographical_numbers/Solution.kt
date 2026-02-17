package lexicographical_numbers

class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val digits = n.toString().length
        val result = ArrayList<Int>()
        var current = "1"
        while (current.isNotEmpty()) {
            println(current)
            result.add(current.toInt())
            if (current.length < digits && (current + "0").toInt() <= n) {
                current += "0"
            } else if (current.last() != '9')  {
                val increment = incLast(current, n)
                current = if (increment.second) {
                    increment.first
                } else {
                    incLast(current.dropLast(1).dropLastWhile { it == '9' }, n).first
                }
            } else {
                current = incLast(current.dropLastWhile { it == '9' }, n).first
            }
        }
        return result
    }

    fun incLast(num: String, max: Int): Pair<String, Boolean> {
        if (num.isNotEmpty()) {
            val next = num.substring(0, num.length - 1) + (num.last().digitToInt() + 1).toString()
            if (next.toInt() <= max) {
                return next to true
            }
        }
        return num to false
    }
}

fun main() {
    val sol = Solution()
    println(sol.lexicalOrder(13))
    println(sol.lexicalOrder(130))
    println(sol.lexicalOrder(192))
}