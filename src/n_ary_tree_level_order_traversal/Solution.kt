package n_ary_tree_level_order_traversal

class Node(var `val`: Int, children: List<Node?> = listOf()) {
    var children: List<Node?> = children
}

class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = ArrayList<MutableList<Int>>()
        result.add(mutableListOf(root.`val`))
        for (child in root.children) {
            val sub = levelOrder(child)
            for (l in 0 until sub.size) {
                if (result.size <= l + 1) result.add(ArrayList())
                result[l + 1].addAll(sub[l])
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.levelOrder(Node(1, listOf(
        Node(2), Node(3, listOf(
            Node(6), Node(7, listOf(
                Node(11, listOf(
                    Node(14)))
            )))),
        Node(4, listOf(
            Node(8, listOf(
                Node(12))))),
        Node(5, listOf(
            Node(9, listOf(
                Node(13))),
            Node(10))
        )))
    ))
}