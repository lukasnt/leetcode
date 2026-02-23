package battleships_in_a_board

class Solution {
    fun countBattleships(board: Array<CharArray>): Int {
        val m = board.size
        val n = board[0].size
        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                val ship = board[i][j] == 'X'
                val leftShip = j > 0 && board[i][j - 1] == 'X'
                val upShip   = i > 0 && board[i - 1][j] == 'X'
                if (ship && !leftShip && !upShip) count++
            }
        }
        return count
    }
}

fun main() {
    val sol = Solution()
    println(sol.countBattleships(arrayOf(
        charArrayOf('X', '.', '.', 'X'),
        charArrayOf('.', '.', '.', 'X'),
        charArrayOf('.', '.', '.', 'X')
    )))
    println(sol.countBattleships(arrayOf(
        charArrayOf('.')
    )))
    println(sol.countBattleships(arrayOf(
        charArrayOf('X')
    )))
    println(sol.countBattleships(arrayOf(
        charArrayOf('X', 'X', 'X', 'X', '.')
    )))
    println(sol.countBattleships(arrayOf(
        charArrayOf('X', 'X', 'X', 'X', '.'),
        charArrayOf('.', '.', '.', '.', 'X')
    )))
    println(sol.countBattleships(arrayOf(
        charArrayOf('X'),
        charArrayOf('X'),
        charArrayOf('X'),
        charArrayOf('X'),
        charArrayOf('.'),
    )))
}