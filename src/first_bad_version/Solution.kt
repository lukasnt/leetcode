package first_bad_version

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

abstract class VersionControl(val badVersion: Int) {
    fun isBadVersion(version: Int): Boolean {
        println("isBadVersion($version)")
        return version >= badVersion
    }
    abstract fun firstBadVersion(n: Int): Int
}

class Solution(badVersion: Int) : VersionControl(badVersion) {
    override fun firstBadVersion(n: Int) : Int {
        return firstBadVersion(1, n)
    }

    fun firstBadVersion(left: Int, end: Int): Int {
        if (left == end) return left
        val mid = ((left.toLong() + end) / 2).toInt()
        return if (isBadVersion(mid)) {
            firstBadVersion(left, mid)
        } else {
            firstBadVersion(mid + 1, end)
        }
    }
}

fun main() {
    var sol = Solution(4)
    println(sol.firstBadVersion(5))
    println(sol.firstBadVersion(4))
    println(sol.firstBadVersion(6))
    println(sol.firstBadVersion(7))
    println(sol.firstBadVersion(8))

    sol = Solution(1)
    println(sol.firstBadVersion(5))
    println(sol.firstBadVersion(4))
    println(sol.firstBadVersion(6))
    println(sol.firstBadVersion(7))
    println(sol.firstBadVersion(8))

    sol = Solution(1702766719)
    println(sol.firstBadVersion(2126753390))
}