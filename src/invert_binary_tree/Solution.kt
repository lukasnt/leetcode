package invert_binary_tree

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = right
        root.right = left
        return root
    }


    fun printSolve(root: TreeNode?) {
        val result = invertTree(root)
        println(treeString(result))
    }

    fun treeString(root: TreeNode?): String {
        return if (root == null) ""
        else {
            "{ val: ${root.`val`}, left: ${treeString(root.left)}, right: ${treeString(root.right)} }"
        }
    }

}

fun main() {
    val sol = Solution()
    sol.printSolve(TreeNode(4,
        TreeNode(2, TreeNode(1), TreeNode(3)),
        TreeNode(7, TreeNode(6), TreeNode(8))
    ))
    sol.printSolve(TreeNode(2,
        TreeNode(1),
        TreeNode(3)
    ))
    sol.printSolve(TreeNode(2,
        TreeNode(1),
    ))
    sol.printSolve(TreeNode(2))
    sol.printSolve(null)
}