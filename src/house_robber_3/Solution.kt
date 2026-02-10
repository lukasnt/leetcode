package house_robber_3

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun rob(root: TreeNode?): Int {
        if (root == null) return 0
        val include: MutableMap<TreeNode, Int> = HashMap()
        val skip: MutableMap<TreeNode, Int> = HashMap()
        return maxOf(robSkip(root, include, skip), robInclude(root, include, skip))
    }

    fun robInclude(root: TreeNode?, include: MutableMap<TreeNode, Int>, skip: MutableMap<TreeNode, Int>): Int {
        if (root == null) return 0
        if (include.contains(root)) return include[root]!!
        val result = robSkip(root.left, include, skip) + robSkip(root.right, include, skip) + root.`val`
        include[root] = result
        return result
    }

    fun robSkip(root: TreeNode?, include: MutableMap<TreeNode, Int>, skip: MutableMap<TreeNode, Int>): Int {
        if (root == null) return 0
        if (skip.contains(root)) return skip[root]!!
        val left = maxOf(robSkip(root.left, include, skip), robInclude(root.left, include, skip))
        val right = maxOf(robSkip(root.right, include, skip), robInclude(root.right, include, skip))
        val result = left + right
        skip[root] = result
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.rob(TreeNode(3, TreeNode(2, null, TreeNode(3)), TreeNode(3, null, TreeNode(1)))))
    println(sol.rob(TreeNode(3, TreeNode(4, TreeNode(1), TreeNode(3)), TreeNode(5, null, TreeNode(1)))))
    println(sol.rob(TreeNode(4, TreeNode(1, TreeNode(2, TreeNode(3))))))
    println(sol.rob(TreeNode(4, TreeNode(1, TreeNode(2, TreeNode(3)), TreeNode(5)), TreeNode(5))))
    println(sol.rob(TreeNode(4, TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(5)), TreeNode(5)))))
}