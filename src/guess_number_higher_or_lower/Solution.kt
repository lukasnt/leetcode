package guess_number_higher_or_lower

abstract class GuessGame(val pick: Int) {

    /**
     * The API guess is defined in the parent class.
     * @param  num   your guess
     * @return        -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     */
    fun guess(num: Int): Int {
        return if (num > pick) -1
        else if (num < pick) 1
        else 0
    }

    abstract fun guessNumber(n: Int): Int
}

class Solution(answer: Int) : GuessGame(answer) {
    override fun guessNumber(n: Int): Int {
        return guessNumberRange(1, n)
    }

    private fun guessNumberRange(low: Int, high: Int): Int {
        val mid = ((low.toLong() + high) / 2).toInt()
        val guess = guess(mid)
        return when (guess) {
            -1 -> guessNumberRange(low, mid - 1)
             1 -> guessNumberRange(mid + 1, high)
            else -> mid
        }
    }
}

fun main() {
    var sol = Solution(20)
    println(sol.guessNumber(30))
    println(sol.guessNumber(20))
    sol = Solution(3)
    println(sol.guessNumber(4))
    println(sol.guessNumber(3))
    println(sol.guessNumber(5))
    sol = Solution(1)
    println(sol.guessNumber(1))
    sol = Solution(1702766719)
    println(sol.guessNumber(2126753390))
}