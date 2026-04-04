package most_frequent_subtree_sum

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val counts = HashMap<Int, Int>()
        treeSum(root, counts)
        return (counts.values.maxOrNull() ?: 0).let { max ->
            counts.filter { entry -> entry.value == max }
                .keys.toIntArray()
        }
    }

    private fun treeSum(root: TreeNode?, counts: MutableMap<Int, Int>): Int {
        if (root == null) return 0
        return (root.`val` + treeSum(root.left, counts) + treeSum(root.right, counts)).let {
            counts[it] = counts.getOrDefault(it, 0) + 1
            it
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.findFrequentTreeSum(TreeNode(5,
        TreeNode(2),
        TreeNode(-3)
    )).contentToString())
    println(sol.findFrequentTreeSum(TreeNode(5,
        TreeNode(2),
        TreeNode(-5)
    )).contentToString())
    println(sol.findFrequentTreeSum(TreeNode(5)).contentToString())
}