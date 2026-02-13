package linked_list_random_node

import kotlin.random.Random

class ListNode(var `val`: Int, next: ListNode? = null) {
    var next: ListNode? = next
}

class Solution(val head: ListNode?) {

    val array: ArrayList<Int> = ArrayList()

    fun getRandom(): Int {
        if (array.isEmpty()) {
            var current = head
            while (current != null) {
                array.add(current.`val`)
                current = current.next
            }
        }
        val test = LinkedHashSet<Int>()
        return array[Random.nextInt(array.size)]
    }

}

fun main() {
    var sol = Solution(ListNode(1, ListNode(2, ListNode(3))))
    println(sol.getRandom())
    println(sol.getRandom())
    println(sol.getRandom())
    println(sol.getRandom())
    println(sol.getRandom())
    println(sol.getRandom())

    sol = Solution(ListNode(1))
    println(sol.getRandom())
    println(sol.getRandom())
    println(sol.getRandom())
}
