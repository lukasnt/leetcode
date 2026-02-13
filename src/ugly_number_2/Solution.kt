package ugly_number_2

import java.util.*

class Solution {
    fun nthUglyNumber(n: Int): Int {
        val uglies = HashSet<Long>()
        val next = PriorityQueue<Long>()
        next.add(1)
        var i = 0
        var last = 0L
        while (i < n) {
            last = next.poll()
            if (last * 2 !in uglies) {
                next.add(last * 2)
                uglies.add(last * 2)
            }
            if (last * 3 !in uglies) {
                next.add(last * 3)
                uglies.add(last * 3)
            }
            if (last * 5 !in uglies) {
                next.add(last * 5)
                uglies.add(last * 5)
            }
            i++
        }
        return last.toInt()
    }
}

fun main() {
    val sol = Solution()
    println(sol.nthUglyNumber(10))
    println(sol.nthUglyNumber(11))
    println(sol.nthUglyNumber(12))
    println(sol.nthUglyNumber(13))
    println(sol.nthUglyNumber(1))
    println(sol.nthUglyNumber(1407))
    println(sol.nthUglyNumber(1690))
}