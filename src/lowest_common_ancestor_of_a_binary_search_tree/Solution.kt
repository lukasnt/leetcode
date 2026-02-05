package lowest_common_ancestor_of_a_binary_search_tree

class TreeNode(var `val`: Int = 0, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root == p || root == q) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        return if (left != null && right != null) root else left ?: right
    }
}

fun main() {
    val sol = Solution()
    val p1 = TreeNode(2, TreeNode(0), TreeNode(4, TreeNode(3), TreeNode(5)))
    val q1 = TreeNode(8, TreeNode(7), TreeNode(9))
    println(sol.lowestCommonAncestor(TreeNode(6, p1, q1), p1, q1)?.`val`)

    val q2 = TreeNode(4, TreeNode(3), TreeNode(5))
    val p2 = TreeNode(2, TreeNode(0), q2)
    println(sol.lowestCommonAncestor(TreeNode(6, p2, TreeNode(8, TreeNode(7), TreeNode(9))), p2, q2)?.`val`)

    val q3 = TreeNode(1)
    val p3 = TreeNode(2, q3)
    println(sol.lowestCommonAncestor(p3, p3, q3)?.`val`)
}