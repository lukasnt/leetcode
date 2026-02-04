package reorder_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null) return
        var current: ListNode? = head
        var mid: ListNode? = head
        var n = 1
        while (current != null) {
            if (n % 2 == 1 && n > 1) {
                mid = mid?.next
            }
            current = current.next
            n++
        }
        var prev = mid
        current = mid?.next
        while (current != null) {
            val temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        var tailNext = prev
        var headNext = head
        while (headNext != mid && headNext != null && tailNext != null) {
            var temp = headNext.next
            headNext.next = tailNext
            headNext = temp
            temp = tailNext.next
            tailNext.next = headNext
            tailNext = temp
        }
        tailNext?.next = null
    }

    fun solvePrint(head: ListNode?) {
        reorderList(head)
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
    sol.solvePrint(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6)))))))
    sol.solvePrint(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
    sol.solvePrint(ListNode(1, ListNode(2, ListNode(3, ListNode(4)))))
    sol.solvePrint(ListNode(1, ListNode(2, ListNode(3))))
    sol.solvePrint(ListNode(1, ListNode(2)))
    sol.solvePrint(ListNode(1))
}