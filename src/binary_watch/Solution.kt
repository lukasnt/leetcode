package binary_watch

class Solution {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        return readBinaryWatch(turnedOn, HashSet(), HashSet()).map {
            "${it.first}:${it.second.toString().padStart(2, '0')}"
        }
            .toSet().toList()
    }

    fun readBinaryWatch(turnedOn: Int, minutesExcluded: MutableSet<Int>, hoursExcluded: MutableSet<Int>): List<Pair<Int, Int>> {
        if (turnedOn == 0) return listOf(0 to 0)
        if (hoursExcluded.sum() >= 12) return emptyList()
        if (minutesExcluded.sum() >= 60) return emptyList()
        val minutes = listOf(1,2,4,8,16,32)
        val hours = listOf(1,2,4,8)
        val result = ArrayList<Pair<Int, Int>>()
        for (minute in minutes) {
            if (minute !in minutesExcluded) {
                minutesExcluded.add(minute)
                readBinaryWatch(turnedOn - 1, minutesExcluded, hoursExcluded).forEach {
                    if (it.second + minute < 60) {
                        result.add(it.first to it.second + minute)
                    }
                }
                minutesExcluded.remove(minute)
            }
        }
        for (hour in hours) {
            if (hour !in hoursExcluded) {
                hoursExcluded.add(hour)
                readBinaryWatch(turnedOn - 1, minutesExcluded, hoursExcluded).forEach {
                    if (it.first + hour < 12) {
                        result.add(it.first + hour to it.second)
                    }
                }
                hoursExcluded.remove(hour)
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.readBinaryWatch(1))
    println(sol.readBinaryWatch(2))
    println(sol.readBinaryWatch(9))
    println(sol.readBinaryWatch(10))
    println(sol.readBinaryWatch(0))
}