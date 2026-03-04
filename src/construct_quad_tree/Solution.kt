package construct_quad_tree

class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        if (grid.isEmpty()) return null
        return construct(grid, 0, 0, grid.size)
    }

    fun construct(grid: Array<IntArray>, row: Int, col: Int, size: Int): Node {
        if (size == 1) return Node(grid[row][col] == 1, true)
        val half = size / 2
        val topLeft     = construct(grid, row       , col       , half)
        val topRight    = construct(grid, row       , col + half, half)
        val bottomLeft  = construct(grid, row + half, col       , half)
        val bottomRight = construct(grid, row + half, col + half, half)
        val result = Node(`val` = false, isLeaf = false)
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            result.isLeaf = topLeft.`val`    == topRight.`val`
                         && topRight.`val`   == bottomLeft.`val`
                         && bottomLeft.`val` == bottomRight.`val`
            result.`val` = bottomLeft.`val`
        }
        if (!result.isLeaf) {
            result.topLeft     = topLeft
            result.topRight    = topRight
            result.bottomLeft  = bottomLeft
            result.bottomRight = bottomRight
        }
        return result
    }
}