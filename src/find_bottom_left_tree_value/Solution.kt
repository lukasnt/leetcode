package find_bottom_left_tree_value

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        if (root == null) return 0
        return bottomLeftValueHeight(root, 0).first
    }

    private fun bottomLeftValueHeight(root: TreeNode, height: Int): Pair<Int, Int> {
        val left  = root.left?.let  { bottomLeftValueHeight(it, height + 1) } ?: (root.`val` to height)
        val right = root.right?.let { bottomLeftValueHeight(it, height + 1) } ?: (0 to height)
        return if (right.second > left.second) right else left
    }
}

fun main() {
    val sol = Solution()
    println(sol.findBottomLeftValue(TreeNode(2, TreeNode(1), TreeNode(3))))
    println(sol.findBottomLeftValue(TreeNode(1,
        TreeNode(2, TreeNode(4)),
        TreeNode(3,
            TreeNode(5,
                TreeNode(7)),
            TreeNode(6))
    )))
}