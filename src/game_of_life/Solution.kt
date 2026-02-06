package game_of_life

class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val m = board.size
        val n = board[0].size
        val lastRow = IntArray(n) { board[0][it] }
        val rowTemp = IntArray(n) { board[0][it] }
        for (i in 0 until m) {
            var last = 0
            for (j in 0 until n) {
                var neighbors = 0
                for (x in -1..1) {
                    for (y in -1..1) {
                        if (!(x == 0 && y == 0) && i + y in 0..<m && j + x in 0..<n) {
                            if (y == -1) {
                                if (lastRow[j + x] == 1) neighbors++
                                continue
                            }
                            if (y == 0 && x == -1){
                                if (last == 1) neighbors++
                                continue
                            }
                            if (board[i + y][j + x] == 1) neighbors++
                        }
                    }
                }
                last = board[i][j]
                rowTemp[j] = board[i][j]
                if (board[i][j] == 1) {
                    if (neighbors < 2) board[i][j] = 0
                    else if (neighbors <= 3) board[i][j] = 1
                    else board[i][j] = 0
                } else if (neighbors == 3) board[i][j] = 1
            }
            for (j in 0 until n) {
                lastRow[j] = rowTemp[j]
            }
        }
    }

    fun solvePrint(board: Array<IntArray>) {
        gameOfLife(board)
        for (row in board) {
            println(row.contentToString())
        }
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrint(arrayOf(
        intArrayOf(0,1,0),
        intArrayOf(0,0,1),
        intArrayOf(1,1,1),
        intArrayOf(0,0,0)
    ))
    sol.solvePrint(arrayOf(
        intArrayOf(1,1),
        intArrayOf(1,0)
    ))
}