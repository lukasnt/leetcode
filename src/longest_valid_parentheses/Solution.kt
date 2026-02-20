package longest_valid_parentheses

class Solution {
    fun longestValidParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        var longest = 0
        var current = 0
        for (c in s) {
            when (c) {
                '(' -> stack.add(1)
                ')' -> {
                    if (stack.size == 1) {
                        current += stack.removeLast() + 1
                        if (current > longest) longest = current
                    } else if (stack.isNotEmpty()) {
                        val last = stack.removeLast() + 1
                        stack.add(stack.removeLast() + last)
                        if (last > longest) longest = last
                    } else {
                        current = 0
                    }
                }
            }
        }
        return maxOf(longest, if (stack.isNotEmpty()) stack.max() - 1 else 0)
    }
}

fun main() {
    val sol = Solution()
    println(sol.longestValidParentheses("(()"))
    println(sol.longestValidParentheses(")()())"))
    println(sol.longestValidParentheses(")"))
    println(sol.longestValidParentheses(")((()))())"))
    println(sol.longestValidParentheses(")((()))())()(())()(())"))
    println(sol.longestValidParentheses(""))
    println(sol.longestValidParentheses("()(()"))
    println(sol.longestValidParentheses("(()()"))
    println(sol.longestValidParentheses("(((((()())())()"))
    println(sol.longestValidParentheses("(()()(())(("))
}