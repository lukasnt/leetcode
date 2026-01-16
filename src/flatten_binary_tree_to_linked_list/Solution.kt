package flatten_binary_tree_to_linked_list


class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) return
        val leftHead = headFlatten(root.left)
        headFlatten(root.right)
        leftHead?.right = root.right
        root.right = root.left ?: root.right
        root.left = null
    }

    fun headFlatten(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.left == null && root.right == null) return root
        val leftHead = headFlatten(root.left)
        val rightHead = headFlatten(root.right)
        leftHead?.right = root.right
        root.right = root.left ?: root.right
        root.left = null
        return rightHead ?: leftHead ?: root
    }
}

fun printTree(root: TreeNode?) {
    if (root == null) return
    printTree(root.left)
    print(root.`val`.toString() + "-")
    printTree(root.right)
}

fun main() {
    val sol = Solution()
    var root: TreeNode? = TreeNode(
        1,
        TreeNode(2, TreeNode(3), TreeNode(4)),
        TreeNode(5, null, TreeNode(6))
    )
    sol.flatten(root)
    printTree(root)
    println()

    root = TreeNode(
        0
    )
    sol.flatten(root)
    printTree(root)
    println()

    root = TreeNode(
        1,
        TreeNode(2, TreeNode(3), TreeNode(4)),
        TreeNode(5, null, TreeNode(6, null, TreeNode(7, TreeNode(8), TreeNode(9))))
    )
    sol.flatten(root)
    printTree(root)
    println()

    root = TreeNode(
        1,
        TreeNode(2, TreeNode(3)),
        TreeNode(5, null, TreeNode(6, null, TreeNode(7, TreeNode(8))))
    )
    sol.flatten(root)
    printTree(root)
    println()
}