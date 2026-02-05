package largest_number

class Solution {
    fun largestNumber(nums: IntArray): String {
        return nums.map { it.toString() }
            .sortedWith { a, b -> (b + a).toULong().compareTo((a + b).toULong()) }
            .joinToString(separator = "")
            .trimStart('0')
            .ifEmpty { "0" }
    }
}

fun main() {
    val sol = Solution()
    println(sol.largestNumber(intArrayOf(111311,1113)))
    println(sol.largestNumber(intArrayOf(10,2)))
    println(sol.largestNumber(intArrayOf(3,30,34,5,9)))
    println(sol.largestNumber(intArrayOf(0,0)))
}