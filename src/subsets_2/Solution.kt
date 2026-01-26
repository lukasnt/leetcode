package subsets_2


class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        return subsets(nums, nums.size - 1)
            .map { it.entries.fold(listOf<Int>())
                { subset, entry -> subset.plus(List(entry.value) { entry.key }) }
            }
            .toList()
    }

    fun subsets(nums: IntArray, end: Int): Set<Map<Int, Int>> {
        if (end == -1) return setOf(mapOf())
        val added: MutableSet<Map<Int, Int>> = HashSet()
        val prev = subsets(nums, end - 1)
        for (sub in prev) {
            val newSub = sub.plus(Pair(nums[end], sub.getOrDefault(nums[end], 0) + 1))
            added.add(newSub)
        }
        return prev.plus(added)
    }
}

fun main() {
    val sol = Solution()
    println(sol.subsetsWithDup(intArrayOf(1, 2, 2)))
    println(sol.subsetsWithDup(intArrayOf(0)))
    println(sol.subsetsWithDup(intArrayOf(2, 2, 1, 2, 2)))
    println(sol.subsetsWithDup(intArrayOf(1, 2, 2, 3)))
}