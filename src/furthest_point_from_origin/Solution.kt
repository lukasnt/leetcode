package furthest_point_from_origin

class Solution {
    fun furthestDistanceFromOrigin(moves: String): Int {
        val lefts   = moves.count { it == 'L' }
        val rights  = moves.count { it == 'R' }
        val empties = moves.count { it == '_' }
        return maxOf(lefts, rights) + empties - minOf(lefts, rights)
    }
}

fun main() {
    val sol = Solution()
    println(sol.furthestDistanceFromOrigin("L_RL__R"))
    println(sol.furthestDistanceFromOrigin("_R__LL_"))
    println(sol.furthestDistanceFromOrigin("_______"))
}