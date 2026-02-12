package different_ways_to_add_parentheses

class Solution {
    fun diffWaysToCompute(expression: String): List<Int> {
        val nums = expression.split("+", "-", "*").map { it.toInt() }
        val ops = expression.filter { it == '+' || it == '-' || it == '*' }
        return diffWaysToCompute(nums, ops, 0, nums.size - 1)
    }

    fun diffWaysToCompute(nums: List<Int>, ops: String, start: Int, end: Int): List<Int> {
        val result = ArrayList<Int>()
        if (start == end) {
            result.add(nums[start])
        }
        for (mid in start until end) {
            val first = diffWaysToCompute(nums, ops, start, mid)
            val second = diffWaysToCompute(nums, ops, mid + 1, end)
            for (a in first) {
                for (b in second) {
                    result.add(compute(ops[mid], a, b))
                }
            }
        }
        return result
    }

    fun compute(op: Char, a: Int, b: Int): Int {
        return when (op) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            else -> 0
        }
    }
}

fun main() {
    val sol = Solution()
    println(sol.diffWaysToCompute("2-1-1"))
    println(sol.diffWaysToCompute("2*3-4*5"))
    println(sol.diffWaysToCompute("2*3-4*5+3-11*50"))
    println(sol.diffWaysToCompute("25"))
    println(sol.diffWaysToCompute("25-1+2"))
}