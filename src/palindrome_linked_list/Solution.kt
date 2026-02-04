package palindrome_linked_list

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return false
        if (head.next == null) return true
        var current = head
        var mid = head
        var midPrev: ListNode? = null
        var midNext: ListNode? = mid.next
        var n = 0
        while (current != null) {
            if (n % 2 == 1 && n > 1) {
                mid?.next = midPrev
                midPrev = mid
                mid = midNext
                midNext = midNext?.next
            }
            current = current.next
            n++
        }
        mid?.next = midPrev
        var left = mid
        var right = if (n % 2 == 0) midNext else midNext?.next
        while (left != null || right != null) {
            if (left?.`val` != right?.`val`) return false
            left = left?.next
            right = right?.next
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.isPalindrome(ListNode(1, ListNode(2, ListNode(3, ListNode(2, ListNode(1)))))))
    println(sol.isPalindrome(ListNode(1, ListNode(2, ListNode(2, ListNode(1))))))
    println(sol.isPalindrome(ListNode(1, ListNode(2))))
    println(sol.isPalindrome(ListNode(1, ListNode(2, ListNode(1)))))
    println(sol.isPalindrome(ListNode(1, ListNode(2, ListNode(3)))))
    println(sol.isPalindrome(ListNode(1)))
    println(sol.isPalindrome(ListNode(1, ListNode(1))))
}