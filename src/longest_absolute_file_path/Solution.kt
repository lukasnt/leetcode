package longest_absolute_file_path

class Solution {
    fun lengthLongestPath(input: String): Int {
        var maxPath = Int.MIN_VALUE
        val dirs = ArrayDeque<Int>()
        for (line in input.split("\n")) {
            var d = 0
            var path = 0
            var file = false
            var name = 0
            for (c in line) {
                when (c) {
                    '\t' -> path += dirs[d++]
                    '.' -> {
                        file = true
                        name++
                    }
                    else -> name++
                }
            }
            while (dirs.size > d) {
                dirs.removeLast()
            }
            if (file) {
                maxPath = maxOf(maxPath, path + d + name)
            } else {
                dirs.add(name)
            }
        }
        return maxOf(maxPath, 0)
    }
}

fun main() {
    val sol = Solution()
    println(sol.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))
    println(sol.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"))
    println(sol.lengthLongestPath("a"))
    println(sol.lengthLongestPath("a.tar.gz"))
}