package h_index

class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        for (h in 0 until citations.size) {
            if (citations[h] < h + 1) return h
        }
        return citations.size
    }
}

fun main() {
    val sol = Solution()
    println(sol.hIndex(intArrayOf(3,0,6,1,5)))
    println(sol.hIndex(intArrayOf(1,3,1)))
}