package walking_robot_simulation

class Solution {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val obstacleSet = obstacles.map { it[0] to it[1] }.toHashSet()
        var maxDistance = 0
        var (xPos, yPos) = 0 to 0
        var (xDir, yDir) = 0 to 1
        for (command in commands) {
            when (command) {
                -1 -> {
                    val temp = xDir
                    xDir = yDir
                    yDir = -temp
                }
                -2 -> {
                    val temp = xDir
                    xDir = -yDir
                    yDir = temp
                }
            }
            for (i in 0 until command) {
                val next = (xPos + xDir) to (yPos + yDir)
                if (next in obstacleSet) break
                xPos = next.first
                yPos = next.second
                val distance = xPos * xPos + yPos * yPos
                if (distance > maxDistance) maxDistance = distance
            }
        }
        return maxDistance
    }
}

fun main() {
    val sol = Solution()
    println(sol.robotSim(intArrayOf(4,-1,3), arrayOf()))
    println(sol.robotSim(intArrayOf(4,-1,4,-2,4), arrayOf(intArrayOf(2,4))))
    println(sol.robotSim(intArrayOf(6,-1,-1,6), arrayOf(intArrayOf(0,0))))
}