package binary_tree_right_side_view

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val right = subRightSideView(root.right, 0)
        val left = subRightSideView(root.left, right.size)
        return listOf(root.`val`)
            .plus(right)
            .plus(left)
    }

    fun subRightSideView(root: TreeNode?, skip: Int): List<Int> {
        if (root == null) return emptyList()
        val top = if (skip > 0) emptyList() else listOf(root.`val`)
        val right = subRightSideView(root.right, maxOf(skip - 1, 0))
        val left = subRightSideView(root.left, maxOf(skip - 1, 0) + right.size)
        return top
            .plus(right)
            .plus(left)
    }
}

fun main() {
    val sol = Solution()
    println(sol.rightSideView(TreeNode(1, TreeNode(2, null, TreeNode(5)), TreeNode(3, TreeNode(4)))))
    println(sol.rightSideView(TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(5))), TreeNode(3))))
    println(sol.rightSideView(TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(5)), TreeNode(6)), TreeNode(3))))
    println(sol.rightSideView(TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(5)), TreeNode(6)), TreeNode(3, TreeNode(7)))))
    println(sol.rightSideView(null))
}