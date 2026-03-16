package circular_array_loop

class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {
        val n = nums.size
        val visited = BooleanArray(nums.size) { false }
        for (start in nums.indices) {
            if (visited[start]) continue
            val current = HashSet<Int>()
            val positive: Boolean = nums[start] > 0
            var prev = start
            var next = Math.floorMod(start + nums[start], n)
            current.add(start)
            while (positive && nums[next] > 0 || !positive && nums[next] < 0) {
                if (next in current || visited[next]) break
                visited[next] = true
                current.add(next)
                prev = next
                next = Math.floorMod((next + nums[next]), n)
            }
            if (next in current && next != prev) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val sol = Solution()
    println(sol.circularArrayLoop(intArrayOf(2,-1,1,2,2)))
    println(sol.circularArrayLoop(intArrayOf(-1,-2,-3,-4,-5,6)))
    println(sol.circularArrayLoop(intArrayOf(1,-1,5,1,4)))
    println(sol.circularArrayLoop(intArrayOf(-1,-2,-3,-4,-5)))
}