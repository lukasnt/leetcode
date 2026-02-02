package remove_linked_list_elements

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var result: ListNode? = head
        var current = head
        var prev: ListNode? = null
        while (result?.`val` == `val`) {
            result = result.next
        }
        while (current != null) {
            while (current?.`val` == `val`) {
                prev?.next = current.next
                current = current.next
            }
            prev = current
            current = current?.next
        }
        return result
    }

    fun printList(node: ListNode?) {
        if (node == null) {
            println("null")
        } else {
            print("${node.`val`} - > ")
            printList(node.next)
        }
    }

}

fun main() {
    val sol = Solution()
    sol.printList(
        sol.removeElements(
            ListNode(1, ListNode(2, ListNode(6, ListNode(3, ListNode(4, ListNode(5, ListNode(6))))))),
            6
        )
    )
    sol.printList(
        sol.removeElements(
            ListNode(7, ListNode(7, ListNode(7, ListNode(7)))),
            7
        )
    )
    sol.printList(
        sol.removeElements(
            ListNode(7, ListNode(7, ListNode(7, ListNode(7, ListNode(1, ListNode(2, ListNode(7, ListNode(3, ListNode(7))))))))),
            7
        )
    )
    sol.printList(
        sol.removeElements(
            ListNode(1, ListNode(2, ListNode(2, ListNode(1)))),
            2
        )
    )
}