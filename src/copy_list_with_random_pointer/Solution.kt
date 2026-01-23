package copy_list_with_random_pointer


class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}


class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        val nodeMap: MutableMap<Node, Node> = HashMap()
        var old = node
        val head = Node(old.`val`)
        nodeMap[old] = head
        old = old.next
        var current = if (old != null) Node(old.`val`) else null
        head.next = current
        while (old != null && current != null) {
            nodeMap[old] = current
            old = old.next
            current.next = if (old != null) Node(old.`val`) else null
            current = current.next
        }
        old = node
        while (old != null) {
            nodeMap[old]?.random = nodeMap[old.random]
            old = old.next
        }
        return head
    }
}