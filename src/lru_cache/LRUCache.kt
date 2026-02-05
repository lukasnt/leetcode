package lru_cache

class LRUCache(capacity: Int) {

    val capacity = capacity
    val keyStack: LinkedHashSet<Int> = LinkedHashSet()
    val valueMap: MutableMap<Int, Int> = HashMap()

    fun update(key: Int) {
        if (key !in keyStack && keyStack.size == capacity) {
            val first = keyStack.first()
            keyStack.remove(first)
            valueMap.remove(first)
        }
        keyStack.remove(key)
        keyStack.add(key)
    }

    fun get(key: Int): Int {
        if (key in keyStack) {
            update(key)
            return valueMap[key]!!
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        update(key)
        valueMap[key] = value
    }

}

fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))
    cache.put(3, 3)
    println(cache.get(2))
    cache.put(4, 4)
    println(cache.get(1))
    println(cache.get(3))
    println(cache.get(4))
}