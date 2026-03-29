package matchsticks_to_square

class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        val length = matchsticks.sum() / 4
        if (length * 4 != matchsticks.sum()) return false
        var squares = ArrayList<IntArray>(1)
        squares.add(intArrayOf(0, 0, 0, 0))
        for (stick in matchsticks) {
            println(squares.map { it.contentToString() })
            val next = ArrayList<IntArray>(squares.size * 4)
            for (square in squares) {
                val used = HashSet<Int>(4)
                for (i in square.indices) {
                    if (square[i] !in used && stick + square[i] <= length) {
                        val added = square.copyOf()
                        added[i] += stick
                        next.add(added)
                        used.add(square[i])
                    }
                }
            }
            squares = next
        }
        println(squares.map { it.contentToString() })
        return squares.isNotEmpty()
    }
}

fun main() {
    val sol = Solution()
    println(sol.makesquare(intArrayOf(1,1,2,2,2)))
    println(sol.makesquare(intArrayOf(3,3,3,3,4)))
}