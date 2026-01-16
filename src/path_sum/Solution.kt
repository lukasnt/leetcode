package path_sum


class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return if (root == null) false
        else if (root.left == null && root.right == null) {
            root.`val` == targetSum
        } else {
            subHasPathSum(root.left, root.`val`, targetSum)
                || subHasPathSum(root.right, root.`val`, targetSum)
        }
    }

    fun subHasPathSum(root: TreeNode?, currentSum: Int, targetSum: Int): Boolean {
        return if (root == null) false
        else if (root.left == null && root.right == null) {
            (currentSum + root.`val`) == targetSum
        } else {
            subHasPathSum(root.left, currentSum + root.`val`, targetSum)
                    || subHasPathSum(root.right, currentSum + root.`val`, targetSum)
        }
    }
}

fun main() {
    val sol = Solution()
    println(
        sol.hasPathSum(
            TreeNode(
                5,
                TreeNode(
                    4,
                    TreeNode(11, TreeNode(7), TreeNode(2))
                ),
                TreeNode(
                    8,
                    TreeNode(13),
                    TreeNode(4, null, TreeNode(1))
                )
            ),
            22
        )
    )
    println(sol.hasPathSum(TreeNode(1, TreeNode(2), TreeNode(3)), 5))
    println(sol.hasPathSum(TreeNode(1, TreeNode(2), TreeNode(3)), 4))
    println(sol.hasPathSum(TreeNode(1), 1))
    println(sol.hasPathSum(TreeNode(1), 2))
    println(sol.hasPathSum(null, 0))
    println(sol.hasPathSum(TreeNode(1, TreeNode(2)), 1))
}