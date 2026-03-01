package flatten_a_multilevel_doubly_linked_list

class Node(var `val`: Int, prev: Node? = null, next: Node? = null, child: Node? = null) {
    var prev: Node? = prev
    var next: Node? = next
    var child: Node? = child
}

class Solution {
    fun flatten(root: Node?): Node? {
        return flattenHeadTail(root).first
    }

    fun flattenHeadTail(root: Node?): Pair<Node?, Node?> {
        if (root == null) return null to null
        var current = root
        var tail: Node = current
        while (current != null) {
            val flattened = flattenHeadTail(current.child)
            val next = current.next
            tail = current
            if (flattened.first != null) {
                current.next = flattened.first
                flattened.first?.prev = current
                flattened.second?.next = next
                next?.prev = flattened.second
                current.child = null
                tail = flattened.second!!
            }
            current = next
        }
        return root to tail
    }

    fun printList(node: Node?) {
        if (node == null) {
            println()
            return
        }
        print("(${node.prev?.`val`}) <-(${node.`val`})-> (${node.next?.`val`})")
        printList(node.next)
    }
}

fun main() {
    val sol = Solution()
    val node1 = Node(1, null, null, null)
    val node2 = Node(2, node1, null, null)
    val node3 = Node(3, node2, null, null)
    val node4 = Node(4, node3, null, null)
    val node5 = Node(5, node4, null, null)
    val node6 = Node(6, node5, null, null)

    val node7 = Node(7, null, null, null)
    val node8 = Node(8, node7, null, null)
    val node9 = Node(9, node8, null, null)
    val node10 = Node(10, node9, null, null)

    val node11 = Node(11, node10, null, null)
    val node12 = Node(12, node11, null, null)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node3.child = node7
    node4.next = node5
    node5.next = node6
    node7.next = node8
    node8.next = node9
    node8.child = node11
    node9.next = node10
    node11.next = node12

    sol.printList(sol.flatten(node1))


    val nodeA = Node(1, null, null, null)
    val nodeB = Node(2, nodeA, null, null)
    val nodeC = Node(3, null, null, null)
    nodeA.next = nodeB
    nodeA.child = nodeC
    sol.printList(sol.flatten(nodeA))

    val nodeX = Node(1, null, null, null)
    val nodeY = Node(2, null, null, null)
    val nodeZ = Node(3, null, null, null)
    nodeX.child = nodeY
    nodeY.child = nodeZ
    sol.printList(sol.flatten(nodeX))
}