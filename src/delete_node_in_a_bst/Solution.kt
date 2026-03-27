package delete_node_in_a_bst

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == key) {
            if (root.right != null) {
                swapMinValue(root, root, root.right!!)
                return root
            } else {
                return root.left
            }
        } else {
            root.left = deleteNode(root.left, key)
            root.right = deleteNode(root.right, key)
        }
        return root
    }

    fun swapMinValue(root: TreeNode, parent: TreeNode, node: TreeNode) {
        if (node.left == null) {
            root.`val` = node.`val`
            if (parent != root) {
                parent.left = node.right
            } else {
                root.right = node.right
            }
        } else {
            swapMinValue(root, node, node.left!!)
        }
    }

    fun solvePrint(root: TreeNode?, key: Int) {
        val result = deleteNode(root, key)
        println(treeString(result))
    }

    fun treeString(root: TreeNode?): String {
        if (root == null) return ""
        return "{ val: ${root.`val`}, left: ${treeString(root.left)}, right: ${treeString(root.right)} }"
    }

}

fun main() {
    val sol = Solution()
    sol.solvePrint(TreeNode(5,
        TreeNode(3, TreeNode(2), TreeNode(4)),
        TreeNode(6, null, TreeNode(7))
    ), 3)
    sol.solvePrint(TreeNode(5,
        TreeNode(2, null, TreeNode(4)),
        TreeNode(6, null, TreeNode(7))
    ), 0)
    sol.solvePrint(null, 0)
    sol.solvePrint(TreeNode(50,
        TreeNode(30, null, TreeNode(40)),
        TreeNode(70, TreeNode(60), TreeNode(80))
    ), 50)
    sol.solvePrint(TreeNode(5,
        TreeNode(3, TreeNode(2), TreeNode(4)),
        TreeNode(6, null, TreeNode(7))
    ), 5)
    sol.solvePrint(TreeNode(5,
        TreeNode(3, TreeNode(2), TreeNode(4)),
        TreeNode(6, null, TreeNode(7))
    ), 7)
}