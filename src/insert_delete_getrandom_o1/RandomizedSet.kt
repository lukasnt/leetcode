package insert_delete_getrandom_o1

import kotlin.random.Random

class RandomizedSet() {

    val indices = HashMap<Int, Int>()
    val values = ArrayList<Int>()
    var shifted = 0

    fun insert(`val`: Int): Boolean {
        if (!indices.containsKey(`val`)) {
            values.add(`val`)
            indices[`val`] = values.size - 1
            return true
        } else {
            return false
        }
    }

    fun remove(`val`: Int): Boolean {
        if (indices.containsKey(`val`)) {
            val temp = values[shifted]
            values[shifted++] = `val`
            values[indices[`val`]!!] = temp
            indices[temp] = indices[`val`]!!
            indices.remove(`val`)
            return true
        } else {
            return false
        }

    }

    fun getRandom(): Int {
        return values[shifted + Random.nextInt(values.size - shifted)]
    }

}

fun main() {
    val randomizedSet = RandomizedSet()
    println(randomizedSet.insert(1))
    println(randomizedSet.remove(2))
    println(randomizedSet.insert(2))
    println(randomizedSet.getRandom())
    println(randomizedSet.remove(1))
    println(randomizedSet.insert(2))
    println(randomizedSet.insert(1))
    println(randomizedSet.remove(2))
    println(randomizedSet.getRandom())
    println(randomizedSet.getRandom())
    println(randomizedSet.getRandom())
}