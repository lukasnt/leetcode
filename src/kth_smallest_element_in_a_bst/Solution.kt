package kth_smallest_element_in_a_bst


class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return kthSmallestCount(root, k).first!!
    }

    fun kthSmallestCount(node: TreeNode?, k: Int): Pair<Int?, Int> {
        if (node == null) return null to 0
        var count = 0
        val left = kthSmallestCount(node.left, k)
        if (left.first != null) {
            return left
        }
        count += left.second
        if (++count == k) {
            return node.`val` to count
        }
        val right = kthSmallestCount(node.right, k - count)
        count += right.second
        if (right.first != null) {
            return right.first to count
        }
        return null to count
    }
}

fun main() {
    val sol = Solution()
    println(sol.kthSmallest(TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4)), 1))
    println(sol.kthSmallest(TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4)), 2))
    println(sol.kthSmallest(TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4)), 3))
    println(sol.kthSmallest(TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4)), 4))
    println(sol.kthSmallest(TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6)), 1))
    println(sol.kthSmallest(TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6)), 2))
    println(sol.kthSmallest(TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6)), 3))
    println(sol.kthSmallest(TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6)), 4))
    println(sol.kthSmallest(TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6)), 5))
    println(sol.kthSmallest(TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6)), 6))
    println(sol.kthSmallest(TreeNode(1), 1))
    println(sol.kthSmallest(TreeNode(2, TreeNode(1)), 2))
    println(sol.kthSmallest(TreeNode(2, null, TreeNode(3)), 2))
}