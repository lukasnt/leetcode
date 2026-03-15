package assign_cookie

class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var result = 0
        var i = 0
        var j = 0
        while (i < g.size && j < s.size) {
            if (s[j] >= g[i]) {
                result++
                i++
            }
            j++
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.findContentChildren(intArrayOf(1,2,3), intArrayOf(1,1)))
    println(sol.findContentChildren(intArrayOf(1,2), intArrayOf(1,2,3)))
    println(sol.findContentChildren(intArrayOf(1,4,2,3), intArrayOf(0,2,1,3,4)))
    println(sol.findContentChildren(intArrayOf(2,3), intArrayOf(1,1)))
    println(sol.findContentChildren(intArrayOf(), intArrayOf()))
    println(sol.findContentChildren(intArrayOf(), intArrayOf(2)))
    println(sol.findContentChildren(intArrayOf(2), intArrayOf()))
}