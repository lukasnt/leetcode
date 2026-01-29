package maximum_gap

class Solution {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) return 0
        val min = nums.min()
        val max = nums.max()
        val ratio: Double = nums.size.toDouble() / (max - min)
        val buckets: Array<Pair<Int, Int>?> = Array(nums.size) { null }
        for (i in 0 until nums.size) {
            var b = ((nums[i] - min) * ratio).toInt()
            if (b == nums.size) b--
            if (buckets[b] == null) {
                buckets[b] = Pair(nums[i], nums[i])
            } else {
                buckets[b] = Pair(minOf(buckets[b]!!.first, nums[i]), maxOf(buckets[b]!!.second, nums[i]))
            }
        }
        var result = 0
        var last = buckets[0]
        for (b in 1 until nums.size) {
            val current = buckets[b]
            if (last != null && current != null && current.first - last.second > result) {
                result = current.first - last.second
            }
            if (current != null) {
                last = current
            }
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.maximumGap(intArrayOf(3,6,9,1)))
    println(sol.maximumGap(intArrayOf(10)))
    println(sol.maximumGap(intArrayOf(10,5)))
    println(sol.maximumGap(intArrayOf(1,2,3,4,5,6)))
    println(sol.maximumGap(intArrayOf(2,2,3,4,5,6,100,20,50)))
    println(sol.maximumGap(intArrayOf(2,2,3,4,5,6,98,99,100,20,50,75)))
    println(sol.maximumGap(intArrayOf(0,0,0)))
    println(sol.maximumGap(intArrayOf(1,1,1,1,1,2)))
}