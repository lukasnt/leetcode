package add_binary

class Solution {
    fun addBinary(a: String, b: String): String {
        val maxLen = maxOf(a.length, b.length)
        val paddedA = a.padStart(maxLen, '0')
        val paddedB = b.padStart(maxLen, '0')
        val result = StringBuilder(maxLen + 1)
        var carry = false
        for (i in maxLen - 1 downTo 0) {
            val bitA = paddedA[i] != '0'
            val bitB = paddedB[i] != '0'
            val digitSum = bitA xor bitB
            val newBit = digitSum xor carry
            carry = bitA && bitB && !carry || (bitA || bitB) && carry
            result.append(newBit.compareTo(false))
        }
        if (carry) result.append('1')
        return result.reverse().toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.addBinary("11", "1"))
    println(sol.addBinary("1010", "1011"))
    println(sol.addBinary("1111", "1111"))
}