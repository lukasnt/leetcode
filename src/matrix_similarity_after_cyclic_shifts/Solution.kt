package matrix_similarity_after_cyclic_shifts

class Solution {
    fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
        val m = mat.size
        val n = mat[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                val shifted = if (i % 2 == 0) {
                    Math.floorMod(j + k, n)
                } else {
                    Math.floorMod(j - k, n)
                }
                if (mat[i][j] != mat[i][shifted]) return false
            }
        }
        return true
    }
}

fun main() {
    val sol = Solution()
    println(sol.areSimilar(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    ), 4))
    println(sol.areSimilar(arrayOf(
        intArrayOf(1,2,1,2),
        intArrayOf(5,5,5,5),
        intArrayOf(6,3,6,3)
    ), 2))
    println(sol.areSimilar(arrayOf(
        intArrayOf(2,2),
        intArrayOf(2,2)
    ), 3))
}