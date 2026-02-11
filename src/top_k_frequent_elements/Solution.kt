package top_k_frequent_elements

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = HashMap<Int, Int>()
        for (num in nums) {
            counts[num] = counts.getOrDefault(num, 0) + 1
        }
        val buckets = Array<MutableList<Map.Entry<Int, Int>>>(nums.size + 1) { ArrayList() }
        for (entry in counts) {
            buckets[nums.size - entry.value].add(entry)
        }
        val result = IntArray(k)
        var i = 0
        for (j in 0 until buckets.size) {
            for (l in 0 until buckets[j].size) {
                result[i + l] = buckets[j][l].key
            }
            i += buckets[j].size
            if (i >= k) break
        }
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.topKFrequent(intArrayOf(1,1,1,2,2,3), 2).contentToString())
    println(sol.topKFrequent(intArrayOf(1,1,1,2,2,3), 3).contentToString())
    println(sol.topKFrequent(intArrayOf(1), 1).contentToString())
    println(sol.topKFrequent(intArrayOf(1,2,1,2,1,2,3,1,3,2), 2).contentToString())

}