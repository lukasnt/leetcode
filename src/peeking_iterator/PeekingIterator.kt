package peeking_iterator


class PeekingIterator(iterator:Iterator<Int>):Iterator<Int> {

    val iterator = iterator
    val nextQueue: MutableList<Int> = ArrayDeque()

    fun peek(): Int {
        if (nextQueue.isNotEmpty()) {
            return nextQueue.first()
        } else if (hasNext()){
            nextQueue.add(iterator.next())
            return nextQueue.first()
        } else {
            return -1
        }
    }

    override fun next(): Int {
        return if (nextQueue.isNotEmpty()) nextQueue.removeFirst()
        else if (iterator.hasNext()) iterator.next()
        else -1
    }

    override fun hasNext(): Boolean {
        return nextQueue.isNotEmpty() || iterator.hasNext()
    }
}

fun main() {
    val iterator: PeekingIterator = PeekingIterator(listOf(1,2,3).iterator())
    println(iterator.next())
    println(iterator.peek())
    println(iterator.next())
    println(iterator.next())
    println(iterator.hasNext())
}