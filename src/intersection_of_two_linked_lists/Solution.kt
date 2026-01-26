package intersection_of_two_linked_lists

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}


class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var i = 0
        var nodeA = headA
        while (nodeA != null) {
            i++
            nodeA = nodeA.next
        }
        var j = 0
        var nodeB = headB
        while (nodeB != null ) {
            j++
            nodeB = nodeB.next
        }
        val m = i
        val n = j
        i = 0
        j = 0
        nodeA = headA
        nodeB = headB
        if (m > n) {
            while (i < m - n) {
                i++
                nodeA = nodeA?.next
            }
        } else if (n > m) {
            while (j < n - m) {
                j++
                nodeB = nodeB?.next
            }
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA == nodeB) {
                return nodeA
            }
            nodeA = nodeA.next
            nodeB = nodeB.next
        }
        return null
    }

    fun printVal(node: ListNode?) {
        if (node == null) println("null")
        else println(node.`val`)
    }
}

fun main() {
    val sol = Solution()
    var intersection = ListNode(8, ListNode(4, ListNode(5)))
    sol.printVal(sol.getIntersectionNode(
    ListNode(4, ListNode(1, intersection)),
    ListNode(5, ListNode(6, ListNode(1, intersection)))
    ))
    intersection = ListNode(2, ListNode(4))
    sol.printVal(sol.getIntersectionNode(
        ListNode(1, ListNode(9, ListNode(1, intersection))),
        ListNode(3, intersection)
    ))
    sol.printVal(sol.getIntersectionNode(
        ListNode(2, ListNode(6, ListNode(4))),
        ListNode(1, ListNode(5))
    ))
    sol.printVal(sol.getIntersectionNode(
        null,
        ListNode(1, ListNode(5))
    ))
    sol.printVal(sol.getIntersectionNode(
        ListNode(5),
        ListNode(1)
    ))
    sol.printVal(sol.getIntersectionNode(
        null,
        null
    ))
}