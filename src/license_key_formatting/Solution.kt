package license_key_formatting

class Solution {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val result = StringBuilder(k)
        var count = 0
        for (c in s.reversed()) {
            if (c != '-') {
                if (count >= k) {
                    result.append("-")
                    count = 0
                }
                result.append(c.uppercaseChar())
                count++
            }
        }
        return result.reversed().toString()
    }
}

fun main() {
    val sol = Solution()
    println(sol.licenseKeyFormatting("5F3Z-2e-9-w", 4))
    println(sol.licenseKeyFormatting("2-5g-3-J", 2))
    println(sol.licenseKeyFormatting("--a-a-a-a--", 2))

}