package reverse_linked_list

class Solution2 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        val reversed = reverseHeadTail(head).first
        head.next = null
        return reversed
    }

    fun reverseHeadTail(head: ListNode): Pair<ListNode, ListNode> {
        if (head.next == null) {
            return Pair(head, head)
        }
        val reversed = reverseHeadTail(head.next!!)
        reversed.second.next = head
        return Pair(reversed.first, head)
    }

    fun printList(node: ListNode?) {
        if (node == null) {
            println("null")
        } else {
            print("${node.`val`} -> ")
            printList(node.next)
        }
    }

}

fun main() {
    val sol = Solution2()
    sol.printList(sol.reverseList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))
    sol.printList(sol.reverseList(ListNode(1, ListNode(2))))
    sol.printList(sol.reverseList(null))
}