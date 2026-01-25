package compare_version_numbers

class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = version1.split(".")
        val v2 = version2.split(".")
        for (i in 0 until maxOf(v1.size, v2.size)) {
            if (i >= v1.size) {
                if (v2[i].toInt() > 0) return -1 else continue
            }
            if (i >= v2.size) {
                if (v1[i].toInt() > 0) return 1 else continue
            }
            if (v1[i].toInt() > v2[i].toInt()) return 1
            if (v2[i].toInt() > v1[i].toInt()) return -1
        }
        return 0
    }
}

fun main() {
    val sol = Solution()
    println(sol.compareVersion("1.2", "1.10"))
    println(sol.compareVersion("1.01", "1.001"))
    println(sol.compareVersion("1.0", "1.0.0.0"))
    println(sol.compareVersion("1.2", "1.1"))
    println(sol.compareVersion("1.1", "1.1.2"))
    println(sol.compareVersion("1.1.2", "1.1"))
    println(sol.compareVersion("1.1.2", "1.1.2.0.0.0.1"))
    println(sol.compareVersion("1.1.2", "1.1.2.0.0.0.0"))
}