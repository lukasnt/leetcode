package utf_8_validation

class Solution {
    @Suppress("EmptyRange")
    fun validUtf8(data: IntArray): Boolean {
        var i = 0
        while (i < data.size) {
            val first = data[i].toString(2).padStart(8, '0')
            var n = 1
            if (first[0] != '0') {
                for (j in 1 until first.length) {
                    if (first[j] == '1') n++
                    else break
                }
                if (n == 1 || n > 4) return false
            }
            if (i + n > data.size) return false
            for (j in 1 until n) {
                val b = data[i + j].toString(2).padStart(8, '0')
                if (b[0] != '1' || b[1] != '0') return false
            }
            i += n
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.validUtf8(intArrayOf(197,130,1)))
    println(sol.validUtf8(intArrayOf(235,140,4)))
    println(sol.validUtf8(intArrayOf(197,130,1,197,130,1,197,130,197,130,3)))
    println(sol.validUtf8(intArrayOf(197,1,1)))
    println(sol.validUtf8(intArrayOf(197,130,1,197,130,1,197,130,197,3)))
    println(sol.validUtf8(intArrayOf(145)))
    println(sol.validUtf8(intArrayOf(1)))
    println(sol.validUtf8(intArrayOf(250,145,145,145,145)))
    println(sol.validUtf8(intArrayOf(254,145,145,145,145,145,145)))
}