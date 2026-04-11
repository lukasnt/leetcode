package minesweeper

class Solution {

    private val adjacentOffsets: List<Pair<Int, Int>> = (-1..1)
        .flatMap { r -> (-1..1).map { c -> r to c } }
        .minus(0 to 0)

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val (clickRow, clickCol) = click
        val cell = board[clickRow][clickCol]
        when (cell) {
            'M' -> board[clickRow][clickCol] = 'X'
            'E' -> revealCell(clickRow, clickCol, board)
        }
        return board
    }

    private fun revealCell(row: Int, col: Int, board: Array<CharArray>) {
        val adjacent = adjacentOffsets
            .map { (r, c) -> (r + row) to (c + col) }
            .filter { (r, c) -> r in board.indices && c in board[r].indices }
        val mines = adjacent.count { board[it.first][it.second] == 'M' }
        if (mines == 0) {
            board[row][col] = 'B'
            adjacent.filter { board[it.first][it.second] == 'E' }
                .forEach { (r, c) -> revealCell(r, c, board) }
        } else {
            board[row][col] = mines.toString()[0]
        }
    }

    fun solvePrint(board: Array<CharArray>, click: IntArray) {
        updateBoard(board, click).forEach { println(it.contentToString()) }
        println()
    }
}

fun main() {
    val sol = Solution()
    sol.solvePrint(arrayOf(
        charArrayOf('E','E','E','E','E'),
        charArrayOf('E','E','M','E','E'),
        charArrayOf('E','E','E','E','E'),
        charArrayOf('E','E','E','E','E')
    ), intArrayOf(3,0))
    sol.solvePrint(arrayOf(
        charArrayOf('E','E','E','E','E'),
        charArrayOf('E','E','M','E','E'),
        charArrayOf('E','E','E','E','E'),
        charArrayOf('E','E','E','E','E')
    ), intArrayOf(1,2))
    sol.solvePrint(arrayOf(
        charArrayOf('B','1','E','1','B'),
        charArrayOf('B','1','M','1','B'),
        charArrayOf('B','1','1','1','B'),
        charArrayOf('B','B','B','B','B')
    ), intArrayOf(1,2))
}