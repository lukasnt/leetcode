package flatten_nested_list_iterator

class NestedIterator(val nestedList: List<NestedInteger>) {

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int?

        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int): Unit

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger): Unit

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>?
    }

    val indexStack = ArrayDeque<Int>()
    val nestedStack = ArrayDeque<List<NestedInteger>>()
    var index = 0
    var current = nestedList

    fun getNext(): NestedInteger? {
        return if (index < current.size) current[index] else null
    }

    fun removeCompleted() {
        while (index == current.size && indexStack.isNotEmpty() && nestedStack.isNotEmpty()) {
            index = indexStack.removeLast()
            current = nestedStack.removeLast()
        }
    }

    fun removeEmpty() {
        removeCompleted()
        var next = getNext()
        while (next != null && !next.isInteger()) {
            nestedStack.add(current)
            indexStack.add(++index)
            current = next.getList()!!
            index = 0
            removeCompleted()
            next = getNext()
        }
    }

    fun next(): Int {
        removeEmpty()
        return current[index++].getInteger()!!
    }

    fun hasNext(): Boolean {
        removeEmpty()
        return index < current.size || indexStack.isNotEmpty() && nestedStack.isNotEmpty()
    }
}
