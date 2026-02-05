package delete_node_in_a_linked_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun deleteNode(node: ListNode?) {
        var current = node
        var prev = node
        while (current?.next != null) {
            current.`val` = current.next!!.`val`
            prev = current
            current = current.next
        }
        prev?.next = null
    }

    fun solvePrint(head: ListNode?, node: ListNode?) {
        deleteNode(node)
        var current = head
        while (current != null) {
            print("${current.`val`} -> ")
            current = current.next
        }
        println("null")
    }
}

fun main() {
    val sol = Solution()
    val node1 = ListNode(5, ListNode(1, ListNode(9)))
    sol.solvePrint(ListNode(4, node1), node1)
    val node2 = ListNode(1, ListNode(9))
    sol.solvePrint(ListNode(4, ListNode(5, node2)), node2)
    val node3 = ListNode(1, ListNode(9))
    sol.solvePrint(node3, node3)
}