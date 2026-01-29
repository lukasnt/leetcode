package reverse_linked_list_2

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var start: ListNode? = null
        var startPrev: ListNode? = null
        var end: ListNode? = null
        var endNext: ListNode? = null
        var prev: ListNode? = null
        var current = head
        var index = 1
        while (current != null && index < right + 1) {
            val temp = current.next
            if (start != null) {
                current.next = prev
            }
            if (index == left) {
                start = current
                startPrev = prev
            }
            if (index == right) {
                end = current
                endNext = temp
            }
            prev = current
            current = temp
            index++
        }
        start?.next = endNext
        startPrev?.next = end
        return if (left > 1) head else end
    }

    fun printList(head: ListNode?) {
        var current = head
        while (current != null) {
            print("${current.`val`} -> ")
            current = current.next
        }
        println()
    }
}

fun main() {
    val sol = Solution()
    sol.printList(sol.reverseBetween(
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))),
        2,
        4
    ))
    sol.printList(sol.reverseBetween(
        ListNode(5),
        1,
        1
    ))
    sol.printList(sol.reverseBetween(
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))),
        1,
        5
    ))
    sol.printList(sol.reverseBetween(
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))),
        2,
        5
    ))
    sol.printList(sol.reverseBetween(
        ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))),
        1,
        4
    ))
    sol.printList(sol.reverseBetween(
        ListNode(5, ListNode(2)),
        1,
        2
    ))
    sol.printList(sol.reverseBetween(
        ListNode(5, ListNode(2)),
        1,
        1
    ))
    sol.printList(sol.reverseBetween(
        ListNode(5, ListNode(2)),
        2,
        2
    ))
}