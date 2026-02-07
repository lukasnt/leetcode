package sort_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        var result: ListNode? = head
        var first: ListNode? = head
        var second: ListNode? = null
        var length = 1
        while (true) {
            var i = 0
            second = first
            while (i < length && second != null) {
                second = second.next
                i++
            }
            if (second == null) break
            val headMerged = merge(first, second, length)
            result = headMerged.first
            var prev = headMerged.second
            first = prev?.next
            while (true) {
                second = first
                i = 0
                while (i < length && second != null) {
                    second = second.next
                    i++
                }
                if (second != null) {
                    val (nextHead, nextFirst) = merge(first, second, length)
                    prev?.next = nextHead
                    prev = nextFirst
                    first = nextFirst?.next
                } else {
                    break
                }
            }
            first = result
            length *= 2
        }
        return result
    }

    fun merge(first: ListNode?, second: ListNode?, maxLength: Int): Pair<ListNode?, ListNode?> {
        var i = 0
        var j = 0
        var left = first
        var right = second
        var head: ListNode? = null
        var tail: ListNode? = null
        while (left != null && right != null && i < maxLength && j < maxLength) {
            if (left.`val` < right.`val`) {
                if (tail == null) head = left
                tail?.next = left
                tail = left
                val temp = left.next
                left.next = right
                left = temp
                i++
            } else {
                if (tail == null) head = right
                tail?.next = right
                tail = right
                val temp = right.next
                right.next = left
                right = temp
                j++
            }
        }
        if (i < maxLength) {
            while (i < maxLength) {
                tail = left
                left = left?.next
                i++
            }
        }
        if (j < maxLength && right != null) {
            while (j < maxLength) {
                tail = right
                right = right?.next
                j++
            }
        }
        tail?.next = right
        return Pair(head, tail)
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
    sol.printList(sol.sortList(ListNode(4, ListNode(2, ListNode(1, ListNode(3))))))
    sol.printList(sol.sortList(ListNode(-1, ListNode(5, ListNode(3, ListNode(4, ListNode(0)))))))
    sol.printList(sol.sortList(ListNode(-1, ListNode(5, ListNode(3, ListNode(4, ListNode(0, ListNode(-2))))))))
    sol.printList(sol.sortList(ListNode(-1, ListNode(5, ListNode(3, ListNode(4, ListNode(0, ListNode(-2, ListNode(3, ListNode(0))))))))))
    sol.printList(sol.sortList(ListNode(2, ListNode(0))))
    sol.printList(sol.sortList(ListNode(2, ListNode(0, ListNode(-1)))))
    sol.printList(sol.sortList(ListNode(0, ListNode(1))))
    sol.printList(sol.sortList(ListNode(0, ListNode(1, ListNode(2)))))
    sol.printList(sol.sortList(ListNode(0)))
    //testMerged()
}

fun testMerged() {
    val sol = Solution()
    var right = ListNode(2, ListNode(4, null))
    var left = ListNode(1, ListNode(3, right))
    sol.printList(sol.merge(
        left,
        right,
        2
    ).first)
    sol.printList(sol.merge(
        left,
        right,
        2
    ).second)
    sol.printList(sol.merge(
        ListNode(-1, ListNode(3)),
        ListNode(2, ListNode(4)),
        2
    ).first)
    sol.printList(sol.merge(
        ListNode(-1, ListNode(3)),
        ListNode(2, ListNode(4)),
        2
    ).second)
    sol.printList(sol.merge(
        ListNode(-1, ListNode(1)),
        ListNode(2, ListNode(4)),
        2
    ).first)
    sol.printList(sol.merge(
        ListNode(-1, ListNode(1)),
        ListNode(2, ListNode(4)),
        2
    ).second)
    right = ListNode(2, ListNode(4, null))
    left = ListNode(1, ListNode(3, ListNode(5, ListNode(6, right))))
    sol.printList(sol.merge(
        left,
        right,
        4
    ).first)
    sol.printList(sol.merge(
        left,
        right,
        4
    ).second)
    sol.printList(sol.merge(
        ListNode(1, ListNode(3, ListNode(5, ListNode(6)))),
        ListNode(2, ListNode(4)),
        1
    ).first)
    sol.printList(sol.merge(
        ListNode(1, ListNode(3, ListNode(5, ListNode(6)))),
        ListNode(2, ListNode(4)),
        1
    ).second)
}