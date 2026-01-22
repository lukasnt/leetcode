package linked_list_cycle


class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}


class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val nodes = mutableSetOf<ListNode>()
        var current = head
        while (current != null) {
            if (nodes.contains(current)) return true
            nodes.add(current)
            current = current.next
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    val pos = ListNode(2)
    pos.next = ListNode(0, ListNode(-4, pos))
    println(sol.hasCycle(ListNode(3, pos)))
    println(sol.hasCycle(ListNode(3, ListNode(0, null))))
}