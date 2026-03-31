package magical_string

class Solution {
    fun magicalString(n: Int): Int {
        val queue = ArrayDeque<Int>()
        queue.add(2)
        var result = 1
        var count = 3
        var group = 2
        while (count < n) {
            val next = queue.removeFirst()
            if (group % 2 == 0) {
                (1..next).forEach { _ ->
                    queue.add(1)
                    if (count < n) {
                        result++
                        count++
                    }
                }
            } else {
                (1..next).forEach { _ ->
                    queue.add(2)
                    if (count <n) count++
                }
            }
            group++
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.magicalString(6))
    println(sol.magicalString(7))
    println(sol.magicalString(8))
    println(sol.magicalString(1))
    println(sol.magicalString(50))
}