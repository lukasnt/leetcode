package count_complete_tree_nodes

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val leftHeight = minHeight(root.left)
        val rightHeight = minHeight(root.right)
        return if (leftHeight == rightHeight) {
            (1 shl rightHeight) + countNodes(root.left)
        } else {
            (1 shl leftHeight) + countNodes(root.right)
        }
    }

    fun minHeight(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + minHeight(root.right)
    }
}

fun main() {
    val sol = Solution()
    println(sol.countNodes(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3, TreeNode(6)))))
    println(sol.countNodes(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))))
    println(sol.countNodes(TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3))))
    println(sol.countNodes(TreeNode(1, TreeNode(2), TreeNode(3))))
    println(sol.countNodes(TreeNode(1, TreeNode(2))))
    println(sol.countNodes(TreeNode(1)))
}