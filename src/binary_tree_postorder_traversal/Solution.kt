package binary_tree_postorder_traversal

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        return postorderTraversal(root.left)
            .plus(postorderTraversal(root.right))
            .plus(listOf(root.`val`))
    }
}

fun main() {
    val sol = Solution()
    println(sol.postorderTraversal(TreeNode(1, null, TreeNode(2, TreeNode(3)))))
    println(sol.postorderTraversal(TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))), TreeNode(3, null, TreeNode(8, TreeNode(9))))))
    println(sol.postorderTraversal(null))
    println(sol.postorderTraversal(TreeNode(1)))
}