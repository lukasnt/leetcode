package implement_queue_using_stacks



class MyQueue() {
    val stack: ArrayDeque<Int> = ArrayDeque()
    val reversed: ArrayDeque<Int> = ArrayDeque()

    fun rotate() {
        while (!stack.isEmpty()) {
            reversed.add(stack.removeLast())
        }
    }

    fun push(x: Int) {
        stack.add(x)
    }

    fun pop(): Int {
        if (reversed.isEmpty()) rotate()
        return if (!reversed.isEmpty()) reversed.removeLast() else -1
    }

    fun peek(): Int {
        if (reversed.isEmpty()) rotate()
        return if (!reversed.isEmpty()) reversed.last() else -1
    }

    fun empty(): Boolean {
        return stack.isEmpty() && reversed.isEmpty()
    }
}

fun main() {
    val queue = MyQueue()
    queue.push(1)
    queue.push(2)
    println(queue.peek())
    println(queue.pop())
    println(queue.empty())
    queue.push(3)
    println(queue.peek())
    println(queue.pop())
    println(queue.empty())
    println(queue.peek())
    println(queue.pop())
    println(queue.empty())
}
