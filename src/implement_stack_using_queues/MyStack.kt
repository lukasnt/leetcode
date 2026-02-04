package implement_stack_using_queues


class MyStack() {
    val queue: ArrayDeque<Int> = ArrayDeque()
    val buffer: ArrayDeque<Int> = ArrayDeque()

    fun rotate() {
        if (queue.isNotEmpty()) {
            while (queue.size > 1) {
                buffer.addLast(queue.removeFirst())
            }
        } else if (buffer.isNotEmpty()) {
            while (buffer.size > 1) {
                queue.addLast(buffer.removeFirst())
            }
        }
    }

    fun push(x: Int) {
        if (buffer.isNotEmpty()) {
            buffer.addLast(x)
        } else {
            queue.addLast(x)
        }
    }

    fun pop(): Int {
        if (queue.isNotEmpty()) {
            rotate()
            return queue.removeFirst()
        } else if (buffer.isNotEmpty()) {
            rotate()
            return buffer.removeFirst()
        }
        return -1
    }

    fun top(): Int {
        if (buffer.isNotEmpty()) {
            rotate()
            val result = buffer.removeFirst()
            queue.addLast(result)
            return result
        } else if (queue.isNotEmpty()) {
            rotate()
            val result = queue.removeFirst()
            buffer.addLast(result)
            return result
        }
        return -1
    }

    fun empty(): Boolean {
        return queue.isEmpty() && buffer.isEmpty()
    }
}

fun main() {
    val stack = MyStack()
    stack.push(1)
    stack.push(2)
    println(stack.top())
    println(stack.pop())
    println(stack.empty())
    println(stack.pop())
    println(stack.empty())
    stack.push(1)
    stack.push(2)
    println(stack.top())
    println(stack.top())
}