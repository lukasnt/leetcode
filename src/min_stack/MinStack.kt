package min_stack

class MinStack() {

    val fullStack: ArrayDeque<Int> = ArrayDeque()
    val minStack: ArrayDeque<Int> = ArrayDeque()

    fun push(`val`: Int) {
        fullStack.add(`val`)
        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.add(`val`)
        }
    }

    fun pop() {
        val popped = fullStack.removeLast()
        if (!minStack.isEmpty() && popped == minStack.last()) {
            minStack.removeLast()
        }
    }

    fun top(): Int {
        return fullStack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }

}

fun main() {
    var minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())
    minStack.pop()
    println(minStack.top())
    println(minStack.getMin())
    println("--------------")

    minStack = MinStack()
    minStack.push(0)
    minStack.push(0)
    minStack.push(-3)
    minStack.push(1)
    minStack.push(2)
    minStack.push(3)
    println("min: " + minStack.getMin())
    println("top: " + minStack.top())
    minStack.pop()
    println("min: " + minStack.getMin())
    println("top: " + minStack.top())
    minStack.pop()
    println("min: " + minStack.getMin())
    println("top: " + minStack.top())
    minStack.pop()
    println("min: " + minStack.getMin())
    println("top: " + minStack.top())
    minStack.pop()
    println("min: " + minStack.getMin())
    println("top: " + minStack.top())
    minStack.pop()
    println("min: " + minStack.getMin())
    println("top: " + minStack.top())
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */