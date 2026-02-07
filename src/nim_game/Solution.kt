package nim_game

class Solution {
    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.canWinNim(4))
    println(sol.canWinNim(1))
    println(sol.canWinNim(2))
    println(sol.canWinNim(5))
}