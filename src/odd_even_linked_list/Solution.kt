package odd_even_linked_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        val oddHead = head.next
        var evenTail = head
        var current = head.next
        while (current?.next != null) {
            evenTail!!.next = current.next
            evenTail = evenTail.next
            current.next = current.next?.next
            current = evenTail?.next
        }
        evenTail?.next = oddHead
        return head
    }

    fun printList(head: ListNode?) {
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
    sol.printList(sol.oddEvenList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))))
    sol.printList(sol.oddEvenList(ListNode(2, ListNode(1, ListNode(3, ListNode(5, ListNode(6, ListNode(4, ListNode(7)))))))))
    sol.printList(sol.oddEvenList(null))
    sol.printList(sol.oddEvenList(ListNode(1)))
    sol.printList(sol.oddEvenList(ListNode(1, ListNode(2))))
    sol.printList(sol.oddEvenList(ListNode(1, ListNode(2, ListNode(3)))))
    sol.printList(sol.oddEvenList(ListNode(1, ListNode(2, ListNode(3, ListNode(4))))))
}
