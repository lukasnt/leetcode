package random_pick_with_weight

import java.util.TreeMap
import kotlin.random.Random

class Solution(w: IntArray) {

    val weightedIndices = TreeMap<Int, Int>()
    val totalWeight: Int

    init {
        var weightSum = 0
        for (i in w.indices) {
            weightSum += w[i]
            weightedIndices[weightSum] = i
        }
        totalWeight = weightSum
    }

    fun pickIndex(): Int {
        val weight = Random.nextInt(totalWeight)
        return weightedIndices.higherEntry(weight).value
    }

}

fun main() {
    var sol = Solution(intArrayOf(1))
    println((1..10).map { sol.pickIndex() })

    sol = Solution(intArrayOf(1,3))
    println((1..10).map { sol.pickIndex() })
}
