package serialize_and_deserialize_bst

import serialize_and_deserialize_bst.Codec.Companion.testPrint

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Codec() {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val result = ArrayList<String>()
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node != null) {
                result.add(node.`val`.toString())
                queue.add(node.left)
                queue.add(node.right)
            } else {
                result.add("#")
            }
        }
        return result.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val values = data.split(",").map { it.toIntOrNull() }
        val queue = ArrayDeque<TreeNode>()
        var i = 0
        val root = TreeNode(values[i++]!!)
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (i < values.size) {
                val value = values[i++]
                if (value != null) {
                    node.left = TreeNode(value)
                    queue.add(node.left!!)
                }
            }
            if (i < values.size) {
                val value = values[i++]
                if (value != null) {
                    node.right = TreeNode(value)
                    queue.add(node.right!!)
                }
            }
        }
        return root
    }

    fun treeString(root: TreeNode?): String {
        if (root == null) return ""
        return "{ ${root.`val`}, left: ${treeString(root.left)}, right: ${treeString(root.right)} }"
    }

    companion object {
        fun testPrint(root: TreeNode?) {
            val ser = Codec()
            val deser = Codec()
            var tree = ser.serialize(root)
            var res = deser.deserialize(tree)
            println(ser.treeString(root))
            println(tree)
            println(ser.treeString(res))
            println()
        }
    }
}

fun main() {
    testPrint(TreeNode(2, TreeNode(1), TreeNode(3)))
    testPrint(null)
    testPrint(TreeNode(2, null, TreeNode(3)))
    testPrint(TreeNode(2, null, TreeNode(3, null, TreeNode(4, TreeNode(5)))))
    testPrint(
        TreeNode(
            5,
            TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)),
            TreeNode(6)
        )
    )
}