package path_sum_3

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        return pathSum(root, targetSum, ArrayList())
    }

    private fun pathSum(root: TreeNode?, targetSum: Int, sums: MutableList<Long>): Int {
        if (root == null) return 0
        var count = 0
        sums.replaceAll { it + root.`val` }
        sums.add(root.`val`.toLong())
        count += sums.count { it == targetSum.toLong() }
        count += pathSum(root.left, targetSum, sums)
        count += pathSum(root.right, targetSum, sums)
        sums.removeLast()
        sums.replaceAll { it - root.`val` }
        return count
    }
}

fun main() {
    val sol = Solution()
    println(sol.pathSum(TreeNode(10,
        TreeNode(5,
            TreeNode(3, TreeNode(3), TreeNode(-2)),
            TreeNode(2, null, TreeNode(1))),
        TreeNode(-3, null, TreeNode(11)))
        , 8
    ))
    println(sol.pathSum(TreeNode(5,
        TreeNode(4,
            TreeNode(11, TreeNode(7), TreeNode(2))),
        TreeNode(8,
            TreeNode(13),
            TreeNode(4, TreeNode(5), TreeNode(1))))
        , 22
    ))
}