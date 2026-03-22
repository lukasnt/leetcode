package queue_reconstruction_by_height

class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(Comparator
            .comparingInt<IntArray> { it[0] }
            .thenComparingInt { -it[1] }
        )
        for (i in people.size - 1 downTo 0) {
            val temp = people[i]
            for (j in i until i + temp[1]) {
                people[j] = people[j + 1]
            }
            people[i + temp[1]] = temp
        }
        return people
    }

    fun printSolve(people: Array<IntArray>) {
        reconstructQueue(people)
        println(people.contentDeepToString())
    }

}

fun main() {
    val sol = Solution()
    sol.printSolve(arrayOf(intArrayOf(7,0), intArrayOf(4,4), intArrayOf(7,1), intArrayOf(5,0), intArrayOf(6,1), intArrayOf(5,2)))
    sol.printSolve(arrayOf(intArrayOf(6,0), intArrayOf(5,0), intArrayOf(4,0), intArrayOf(3,2), intArrayOf(2,2), intArrayOf(1,4)))
}