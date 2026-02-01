package insertion_sort_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) return null
        var next = head
        var prev: ListNode? = null
        var result = head
        while (next != null) {
            var current = result
            var sortedPrev: ListNode? = null
            while (current != next && next.`val` > current!!.`val`) {
                sortedPrev = current
                current = current.next
            }
            if (sortedPrev != null) {
                sortedPrev.next = next
            } else {
                result = next
            }
            val temp = next.next
            if (next != current) {
                next.next = current
                prev?.next = temp
            } else {
                prev = next
            }
            next = temp
        }
        return result
    }

    fun printList(head: ListNode?): Unit {
        if (head == null) return
        print("${head.`val`} -> ")
        printList(head.next)
        if (head.next == null) println()
    }

}

fun main() {
    val sol = Solution()
    sol.printList(sol.insertionSortList(ListNode(4, ListNode(2, ListNode(1, ListNode(3))))))
    sol.printList(sol.insertionSortList(ListNode(-1, ListNode(5, ListNode(3, ListNode(4, ListNode(0)))))))
    sol.printList(sol.insertionSortList(ListNode(4, ListNode(2))))
    sol.printList(sol.insertionSortList(ListNode(2, ListNode(4))))
    sol.printList(sol.insertionSortList(ListNode(2)))
    sol.printList(sol.insertionSortList(null))
}