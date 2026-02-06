package h_index_2

class Solution {
    fun hIndex(citations: IntArray): Int {
        return hIndexRange(citations, 0, citations.size - 1)
    }

    fun hIndexRange(citations: IntArray, start: Int, end: Int): Int {
        if (start >= end) {
            return citations.size - start - if (citations[start] < citations.size - start) 1 else 0
        }
        val mid = (start + end) / 2
        val h = citations.size - mid
        return if (citations[mid] >= h) {
            hIndexRange(citations, start, mid)
        } else {
            hIndexRange(citations, mid + 1, end)
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.hIndex(intArrayOf(0,1,3,5,6)))
    println(sol.hIndex(intArrayOf(1,2,100)))
    println(sol.hIndex(intArrayOf(0,0,0,0,0,0)))
    println(sol.hIndex(intArrayOf(0,0,0,0,0,1)))
    println(sol.hIndex(intArrayOf(6,7,8,9,10,11)))
    println(sol.hIndex(intArrayOf(5,7,8,9,10,11)))
    println(sol.hIndex(intArrayOf(1)))
    println(sol.hIndex(intArrayOf(0)))
}