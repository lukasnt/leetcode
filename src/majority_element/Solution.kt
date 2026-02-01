package majority_element

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val actives: MutableMap<Int, Int> = HashMap()
        for (i in 0 until nums.size) {
            val num = nums[i]
            val removed = mutableListOf<Int>()
            for (key in actives.keys) {
                if (key != num) {
                    if (actives[key] == 1) {
                        removed.add(key)
                    } else {
                        actives[key] = actives[key]!! - 1
                    }
                }
            }
            for (key in removed) {
                actives.remove(key)
            }
            actives.merge(num, 1, Integer::sum)
        }
        return actives.keys
            .map { key -> Pair(key, nums.count { it == key } ) }
            .maxBy { it.second }
            .first
    }
}

fun main() {
    val sol = Solution()
    println(sol.majorityElement(intArrayOf(3,2,3)))
    println(sol.majorityElement(intArrayOf(2,2,1,1,1,2,2)))
    println(sol.majorityElement(intArrayOf(6,6,6,7,7)))
    println(sol.majorityElement(intArrayOf(1)))
}