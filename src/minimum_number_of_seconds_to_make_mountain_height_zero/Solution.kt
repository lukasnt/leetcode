package minimum_number_of_seconds_to_make_mountain_height_zero

import java.util.*

class Solution {
    fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        val queue = PriorityQueue(
            workerTimes.size,
            Comparator.comparingLong<Triple<Long, Long, Long>> { it.third + it.second }
        )
        var remaining = mountainHeight
        workerTimes.sort()
        var i = 0
        queue.add(Triple(workerTimes[i].toLong(), workerTimes[i].toLong(), 0))
        while (queue.isNotEmpty() && remaining > 0) {
            val next = queue.poll()
            queue.add(Triple(
                next.first,
                next.first + next.second,
                next.second + next.third
            ))
            if (++i < workerTimes.size) {
                queue.add(Triple(
                    workerTimes[i].toLong(),
                    workerTimes[i].toLong(),
                    0
                ))
            }
            remaining--
        }
        return queue.maxOf { it.third }
    }
}

fun main() {
    val sol = Solution()
    println(sol.minNumberOfSeconds(4, intArrayOf(2, 1, 1)))
    println(sol.minNumberOfSeconds(10, intArrayOf(3, 2, 2, 4)))
    println(sol.minNumberOfSeconds(5, intArrayOf(1)))
    println(sol.minNumberOfSeconds(5, intArrayOf(1,7)))
    println(sol.minNumberOfSeconds(5, intArrayOf(1,5)))
}