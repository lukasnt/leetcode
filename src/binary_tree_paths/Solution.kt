package binary_tree_paths

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        if (root == null) return emptyList()
        else if (root.left == null && root.right == null) return listOf("${root.`val`}")
        val result: MutableList<String> = ArrayList()
        val left = binaryTreePaths(root.left)
        val right = binaryTreePaths(root.right)
        for (res in left) {
            result.add("${root.`val`}->$res")
        }
        for (res in right) {
            result.add("${root.`val`}->$res")
        }
        return result
    }
}