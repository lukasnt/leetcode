package mini_parser


class Solution {

    class NestedInteger {

        var value: Int? = null
        var nested: MutableList<NestedInteger>? = null

        // Constructor initializes an empty nested list.
        constructor() {
            nested = ArrayList()
        }

        // Constructor initializes a single integer.
        constructor(value: Int) {
            this.value = value
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean {
            return value != null
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int? {
            return value
        }

        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int): Unit {
            this.value = value
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger): Unit {
            if (nested == null) {
                nested = mutableListOf(ni)
            } else {
                nested!!.add(ni)
            }
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>? {
            return if (isInteger()) null
            else nested
        }
    }

    fun deserialize(s: String): NestedInteger {
        val stack = ArrayDeque<NestedInteger>()
        var current: NestedInteger? = null
        val num = StringBuilder()
        for (c in s) {
            if (c.isDigit() || c == '-') {
                num.append(c)
            } else if (num.isNotEmpty() && current != null) {
                current.add(NestedInteger(num.toString().toInt()))
                num.clear()
            }
            when (c) {
                '[' -> {
                    if (current != null) {
                        stack.add(current)
                    }
                    current = NestedInteger()
                }
                ']' -> {
                    if (stack.isNotEmpty()) {
                        val temp = current
                        current = stack.removeLast()
                        current.add(temp!!)
                    }
                }
            }
        }
        return if (num.isNotEmpty()) NestedInteger(num.toString().toInt())
        else current!!
    }

    fun nestedIntegerString(nestedInteger: NestedInteger): String {
        return if (nestedInteger.isInteger()) {
            nestedInteger.getInteger().toString()
        } else {
            "[${nestedInteger.getList()!!.joinToString(",") { nestedIntegerString(it) }}]"
        }
    }

    fun printNestedInteger(nestedInteger: NestedInteger) {
        println(nestedIntegerString(nestedInteger))
    }
}

fun main() {
    val sol = Solution()
    sol.printNestedInteger(sol.deserialize("324"))
    sol.printNestedInteger(sol.deserialize("[123,[456,[789]]]"))
    sol.printNestedInteger(sol.deserialize("[324,789]"))
    sol.printNestedInteger(sol.deserialize("-324"))
    sol.printNestedInteger(sol.deserialize("[-324,789,-324,-789]"))
    sol.printNestedInteger(sol.deserialize("[123,[456,[-123]],[],[789,[200,-10,[],[]]],-100]"))
}