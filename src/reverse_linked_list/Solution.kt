package reverse_linked_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        return prev
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
    val sol = Solution()
    sol.printList(sol.reverseList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))
    sol.printList(sol.reverseList(ListNode(1, ListNode(2))))
    sol.printList(sol.reverseList(null))
}