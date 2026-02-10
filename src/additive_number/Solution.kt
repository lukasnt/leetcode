package additive_number

class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        if (num.length < 3) return false
        val sol: Array<MutableMap<Long, MutableList<Long>>> = Array(num.length + 1) { HashMap() }
        addSolution(sol, 1, num[0].digitToInt().toLong() + num[1].digitToInt().toLong(), num[1].digitToInt().toLong())
        for (i in 2 until num.length + 1) {
            for (j in 1 until i) {
                if (num[j] == '0' && i - j >= 2 || i - j >= 18) continue
                val current = num.substring(j, i).toLong()
                val prev = sol[j]
                if (current in prev.keys) {
                    for (last in prev[current]!!) {
                        addSolution(sol, i, current + last, current)
                    }
                }
                if (i < num.length && !(num[0] == '0' && j > 1) && j < 18) {
                    val start = num.substring(0, j).toLong()
                    addSolution(sol, i, start + current, current)
                }
            }
        }
        return sol[num.length].isNotEmpty()
    }

    fun addSolution(sol: Array<MutableMap<Long, MutableList<Long>>>, index: Int, sum: Long, last: Long) {
        sol[index].merge(
            sum,
            mutableListOf(last)
        ) { list, value ->
            list.addAll(value)
            list
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.isAdditiveNumber("112358"))
    println(sol.isAdditiveNumber("199100199"))
    println(sol.isAdditiveNumber("1991001991"))
    println(sol.isAdditiveNumber("19910019911991001991199100199112345"))
    println(sol.isAdditiveNumber("0"))
    println(sol.isAdditiveNumber("11"))
    println(sol.isAdditiveNumber("111"))
    println(sol.isAdditiveNumber("112"))
    println(sol.isAdditiveNumber("101"))
    println(sol.isAdditiveNumber("011112"))
}