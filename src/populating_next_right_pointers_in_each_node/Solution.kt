package populating_next_right_pointers_in_each_node


class Node(var `val`: Int, left: Node? = null, right: Node? = null) {
    var left: Node? = left
    var right: Node? = right
    var next: Node? = null
}


class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        if (root.left == null && root.right == null) return root
        val leftConnected = headConnected(root.left)
        val rightConnected = tailConnected(root.right)
        for (i in 0 until leftConnected.size) {
            leftConnected[i].next = rightConnected[i]
        }
        return root
    }

    fun tailConnected(root: Node?): ArrayList<Node> {
        if (root == null) return ArrayList<Node>()
        if (root.left == null && root.right == null) return arrayListOf(root)
        val leftConnected = headConnected(root.left)
        val rightConnected = tailConnected(root.right)
        for (i in 0 until leftConnected.size) {
            leftConnected[i].next = rightConnected[i]
        }
        return arrayListOf(root).plus(tailConnected(root.left)) as ArrayList<Node>
    }

    fun headConnected(root: Node?): ArrayList<Node> {
        if (root == null) return ArrayList<Node>()
        if (root.left == null && root.right == null) return arrayListOf(root)
        val leftConnected = headConnected(root.left)
        val rightConnected = tailConnected(root.right)
        for (i in 0 until leftConnected.size) {
            leftConnected[i].next = rightConnected[i]
        }
        return arrayListOf(root).plus(headConnected(root.right)) as ArrayList<Node>
    }
}

fun main() {
    val sol = Solution()
    println(
        sol.connect(
            Node(
                1,
                Node(2, Node(4), Node(5)),
                Node(3, Node(6), Node(7))
            )
        )
    )
    println(
        sol.connect(
            Node(
                -1,
                Node(0,
                    Node(2, Node(6), Node(7)),
                    Node(3, Node(8), Node(9))),
                Node(1,
                    Node(4, Node(10), Node(11)),
                    Node(5, Node(12), Node(13))
                )
            )
        )
    )
}