package binary_tree_preorder_traversal

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        return listOf(root.`val`)
            .plus(preorderTraversal(root.left))
            .plus(preorderTraversal(root.right))
    }
}

fun main() {
    val sol = Solution()
    println(sol.preorderTraversal(TreeNode(1, TreeNode(2), TreeNode(3))))
    println(sol.preorderTraversal(TreeNode(1, null, TreeNode(2, TreeNode(3)))))
    println(sol.preorderTraversal(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))), TreeNode(3, null, TreeNode(8, TreeNode(9))))))
    println(sol.preorderTraversal(TreeNode(1)))
}