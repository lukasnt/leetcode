package maximum_depth_of_binary_tree


class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}

fun main() {
    val sol = Solution()
    println(
        sol.maxDepth(
            TreeNode(
                3,
                TreeNode(9),
                TreeNode(20, TreeNode(15), TreeNode(7))
            )
        )
    )
    println(
        sol.maxDepth(
            TreeNode(
                3,
                null,
                TreeNode(2)
            )
        )
    )
    println(sol.maxDepth(TreeNode(3)))
    println(sol.maxDepth(null))
    println(sol.maxDepth(TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4, TreeNode(5)))))))
}