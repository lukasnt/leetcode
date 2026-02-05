package course_schedule


class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val neighbors: Array<MutableList<Int>> = Array(numCourses) { ArrayList<Int>() }
        for (pre in prerequisites) {
            neighbors[pre[0]].add(pre[1])
        }
        val visited: MutableSet<Int> = HashSet()
        for (course in 0 until numCourses) {
            if (course !in visited) {
                if (dfsCycle(course, neighbors, visited, LinkedHashSet())) return false
            }
        }
        return true
    }

    fun dfsCycle(node: Int, neighbors: Array<MutableList<Int>>, visited: MutableSet<Int>, path: LinkedHashSet<Int>): Boolean {
        if (node in path) return true
        path.add(node)
        var result = false
        for (neighbor in neighbors[node]) {
            if (neighbor !in visited) {
                if (dfsCycle(neighbor, neighbors, visited, path)) result = true
            }
        }
        path.remove(path.last())
        visited.add(node)
        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.canFinish(1, arrayOf()))
    println(sol.canFinish(2, arrayOf(intArrayOf(1,0))))
    println(sol.canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1))))
    println(sol.canFinish(3, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,0))))
    println(sol.canFinish(3, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(0,2))))
    println(sol.canFinish(4, arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(0,2))))

}