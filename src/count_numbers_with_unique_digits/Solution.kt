package count_numbers_with_unique_digits

class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if (n == 0) return 1
        var pow = 9
        var sol = pow + 1
        for (num in 2 until n + 1) {
            pow *= (10 - num + 1)
            sol += pow
        }
        return sol
    }
}