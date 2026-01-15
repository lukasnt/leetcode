package symmetric_tree


class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        val leftQueue = ArrayDeque<TreeNode?>()
        val rightQueue = ArrayDeque<TreeNode?>()
        leftQueue.addLast(root.left)
        rightQueue.addLast(root.right)
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            val left = leftQueue.removeFirst()
            val right = rightQueue.removeFirst()
            if (left?.`val` != right?.`val`) return false;
            if (left != null && right != null) {
                leftQueue.addLast(left.left)
                leftQueue.addLast(left.right)
                rightQueue.addLast(right.right)
                rightQueue.addLast(right.left)
            }
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.isSymmetric(TreeNode(1)))
    println(sol.isSymmetric(TreeNode(1, TreeNode(2), TreeNode(2))))
    println(sol.isSymmetric(TreeNode(1, TreeNode(2), TreeNode(3))))
    println(sol.isSymmetric(TreeNode(1, TreeNode(2))))
    println(
        sol.isSymmetric(
            TreeNode(
                1,
                TreeNode(2, TreeNode(3, TreeNode(2), TreeNode(1))),
                TreeNode(2, null, TreeNode(3, TreeNode(1), TreeNode(2)))
            )
        )
    )
    println(sol.isSymmetric(null))
}