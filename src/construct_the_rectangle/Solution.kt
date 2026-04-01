package construct_the_rectangle

class Solution {
    fun constructRectangle(area: Int): IntArray {
        var closest = intArrayOf(area, 1)
        for (w in 2 until area) {
            if (area % w == 0) {
                val l = area / w
                if (l >= w) {
                    if (l - w < closest[0] - closest[1]) {
                        closest = intArrayOf(l, w)
                    }
                } else {
                    break
                }
            }
        }
        return closest
    }
}

fun main() {
    val sol = Solution()
    println(sol.constructRectangle(4).contentToString())
    println(sol.constructRectangle(37).contentToString())
    println(sol.constructRectangle(122122).contentToString())
}