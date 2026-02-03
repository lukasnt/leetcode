package combination_sum_3

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val sums: Array<MutableSet<Set<Int>>> = Array(n + 1) { HashSet() }
        for (num in 1..minOf(9, n)) {
            sums[num].add(setOf(num))
            for (s in 1 until n - num + 1) {
                for (prev in sums[s]) {
                    if (prev.size < k && !prev.contains(num)) {
                        sums[s + num].add(prev.plus(num))
                    }
                }
            }
        }
        return sums[n]
            .filter { it.size == k }
            .map { it.toList() }
            .toList()
    }
}

fun main() {
    val sol = Solution()
    println(sol.combinationSum3(3, 7))
    println(sol.combinationSum3(3, 9))
    println(sol.combinationSum3(4, 1))
    println(sol.combinationSum3(3, 24))
    println(sol.combinationSum3(4, 24))
}