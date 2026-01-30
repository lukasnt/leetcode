package binary_search_tree_iterator

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right

    override fun toString(): String {
        return "$`val`"
    }
}

class BSTIterator(root: TreeNode?) {

    enum class Next {
        LEFT, NODE, RIGHT
    }

    val nextStack: ArrayDeque<Pair<TreeNode, Next>> = ArrayDeque()

    init {
        if (root != null) {
            pushNode(root)
        }
    }

    fun pushNode(node: TreeNode): Unit {
        if (node.right != null) {
            nextStack.add(Pair(node.right!!, Next.RIGHT))
        }
        nextStack.add(Pair(node, Next.NODE))
        if (node.left != null) {
            nextStack.add(Pair(node.left!!, Next.LEFT))
        }
        if (!nextStack.isEmpty() && nextStack.last().second == Next.LEFT) {
            pushNode(nextStack.removeLast().first)
        }
    }

    fun next(): Int {
        if (hasNext()) {
            val result = nextStack.removeLast().first.`val`
            if (!nextStack.isEmpty() && nextStack.last().second == Next.RIGHT) {
                pushNode(nextStack.removeLast().first)
            }
            return result
        } else {
            return -1
        }
    }

    fun hasNext(): Boolean {
        return !nextStack.isEmpty()
    }

}

fun main() {
    val root = TreeNode(7, TreeNode(3), TreeNode(15, TreeNode(9), TreeNode(20)))
    val iterator = BSTIterator(root)
    println(iterator.next())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
    println(iterator.next())
    println(iterator.hasNext())
}
