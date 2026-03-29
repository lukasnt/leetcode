package generate_random_point_in_a_circle

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random.Default.nextDouble

class Solution(val radius: Double, val x_center: Double, val y_center: Double) {

    fun randPoint(): DoubleArray {
        val angle = 2 * PI * nextDouble()
        val rad = sqrt(radius * radius * nextDouble())
        return doubleArrayOf(
            x_center + rad * cos(angle),
            y_center + rad * sin(angle)
        )
    }

}

fun main() {
    val sol = Solution(2.0, 1.0, 1.0)
    (1..10).forEach { _ -> println(sol.randPoint().contentToString()) }
}