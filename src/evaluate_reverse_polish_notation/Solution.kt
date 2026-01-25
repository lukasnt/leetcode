package evaluate_reverse_polish_notation

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> stack.add(stack.removeLast() + stack.removeLast())
                "-" -> stack.add(stack.removeAt(stack.size - 2) - stack.removeLast())
                "*" -> stack.add(stack.removeLast() * stack.removeLast())
                "/" -> stack.add(stack.removeAt(stack.size - 2) / stack.removeLast())
                else -> stack.add(token.toInt())
            }
        }
        return stack.removeLast()
    }
}

fun main() {
    val sol = Solution()
    println(sol.evalRPN(arrayOf("2","1","+","3","*")))
    println(sol.evalRPN(arrayOf("4","13","5","/","+")))
    println(sol.evalRPN(arrayOf("4")))
    println(sol.evalRPN(arrayOf("4","-2","/","2","-")))
    println(sol.evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))
}