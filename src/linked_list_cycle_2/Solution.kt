package linked_list_cycle_2


class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}


class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        val nodes = mutableSetOf<ListNode>()
        var current = head
        while (current != null) {
            if (nodes.contains(current)) return current
            nodes.add(current)
            current = current.next
        }
        return null
    }

    companion object{
        fun print(node: ListNode?) {
            println("{ ${node?.`val`} -> ${node?.next?.`val`} }")
        }
    }
}

fun main() {
    val sol = Solution()
    var pos = ListNode(2)
    pos.next = ListNode(0, ListNode(-4, pos))
    Solution.print(sol.detectCycle(ListNode(3, pos)))
    Solution.print(sol.detectCycle(ListNode(4, ListNode(5, ListNode(6, ListNode(7))))))
}