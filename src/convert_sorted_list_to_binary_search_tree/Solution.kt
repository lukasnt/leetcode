package convert_sorted_list_to_binary_search_tree


class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class TreeNode(var `val`: Int, left: TreeNode? = null, right: TreeNode? = null) {
    var left: TreeNode? = left
    var right: TreeNode? = right
}

class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) return null
        if (head.next == null) return TreeNode(head.`val`)
        var mid: ListNode? = head
        var prevMid: ListNode? = null
        var current: ListNode? = head
        var i = 0
        while (current != null) {
            if (i % 2 == 1) {
                prevMid = mid
                mid = mid!!.next
            }
            current = current.next
            i++
        }
        prevMid?.next = null
        val root = TreeNode(mid!!.`val`)
        root.left = sortedListToBST(head)
        root.right = sortedListToBST(mid.next)
        return root
    }

    fun treeString(root: TreeNode?): String {
        if (root == null) return ""
        return "{ ${root.`val`}, left: ${treeString(root.left)}, right: ${treeString(root.right)}}"
    }

    fun printTree(root: TreeNode?) {
        println(treeString(root))
    }
}

fun main() {
    val sol = Solution()
    sol.printTree(sol.sortedListToBST(ListNode(-10, ListNode(-3, ListNode(0, ListNode(5, ListNode(9)))))))
    sol.printTree(sol.sortedListToBST(ListNode(-10, ListNode(-3, ListNode(0, ListNode(5, ListNode(9, ListNode(10))))))))
    sol.printTree(sol.sortedListToBST(ListNode(-10, ListNode(-3, ListNode(0, ListNode(5, ListNode(9, ListNode(10, ListNode(11)))))))))
    sol.printTree(sol.sortedListToBST(null))
    sol.printTree(sol.sortedListToBST(ListNode(1)))
    sol.printTree(sol.sortedListToBST(ListNode(1, ListNode(2))))
    sol.printTree(sol.sortedListToBST(ListNode(1, ListNode(2, ListNode(3)))))
}