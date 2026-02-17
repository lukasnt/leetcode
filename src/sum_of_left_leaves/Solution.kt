package sum_of_left_leaves

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return sumOfLeftLeaves(root, false)
    }

    fun sumOfLeftLeaves(root: TreeNode?, isLeft: Boolean): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null && isLeft) return root.`val`
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false)
    }
}

fun main() {
    val sol = Solution()
    println(sol.sumOfLeftLeaves(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
    println(sol.sumOfLeftLeaves(TreeNode(1)))
}