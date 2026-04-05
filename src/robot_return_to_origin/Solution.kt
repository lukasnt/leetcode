package robot_return_to_origin

class Solution {
    fun judgeCircle(moves: String): Boolean {
        val vertical   = moves.count { it == 'U' } == moves.count { it == 'D' }
        val horizontal = moves.count { it == 'L' } == moves.count { it == 'R' }
        return vertical && horizontal
    }
}

fun main() {
    val sol = Solution()
    println(sol.judgeCircle("UD"))
    println(sol.judgeCircle("LL"))
    println(sol.judgeCircle("LR"))
    println(sol.judgeCircle("ULRD"))
    println(sol.judgeCircle("ULRDL"))
    println(sol.judgeCircle("ULRDD"))
    println(sol.judgeCircle("ULRDU"))
}