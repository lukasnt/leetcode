package remove_k_digits

class Solution {
    fun removeKdigits(num: String, k: Int): String {
        val removed = HashSet<Int>()
        var count = 0
        for (i in 0 until num.length - 1) {
            if (num[i].digitToInt() > num[i + 1].digitToInt()) {
                removed.add(i)
                count++
                for (j in i - 1 downTo 0) {
                    if (num[j].digitToInt() > num[i + 1].digitToInt() && count < k) {
                        if (j in removed) continue
                        removed.add(j)
                        count++
                    } else {
                        break
                    }
                }
            }
            if (count >= k) break
        }
        var l = num.length - 1
        while (count < k) {
            if (l !in removed) {
                removed.add(l)
                count++
            }
            l--
        }
        return num.filterIndexed { index, _ -> index !in removed }
            .dropWhile { it == '0' }
            .ifEmpty { "0" }
    }
}

fun main() {
    val sol = Solution()
    println(sol.removeKdigits("1432219", 3))
    println(sol.removeKdigits("10200", 1))
    println(sol.removeKdigits("10", 2))
    println(sol.removeKdigits("934870928379183473458387546376457346528654", 20))
    println(sol.removeKdigits("123456789999", 5))
    println(sol.removeKdigits("33526221184202197273", 19))
}