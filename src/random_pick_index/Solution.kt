package random_pick_index

class Solution(nums: IntArray) {

    val indices = HashMap<Int, MutableList<Int>>()

    init {
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (!indices.containsKey(num)) {
                indices[num] = ArrayList()
            }
            indices[num]!!.add(i)
        }
    }

    fun pick(target: Int): Int {
        return indices[target]!!.random()
    }

}

fun main() {
    val sol = Solution(intArrayOf(1,2,3,3,3))
    println(sol.pick(3))
    println(sol.pick(1))
    println(sol.pick(3))
}