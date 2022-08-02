class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) {
            when(token) {
                "+" -> stack.addFirst(stack.removeFirst() + stack.removeFirst())
                "-" -> {
                    val x = stack.removeFirst()
                    val y = stack.removeFirst()
                    stack.addFirst(y - x)
                }
                "*" -> stack.addFirst(stack.removeFirst() * stack.removeFirst())
                "/" -> {
                    val x = stack.removeFirst()
                    val y = stack.removeFirst()
                    stack.addFirst(y / x)
                }
                else -> stack.addFirst(token.toInt())
            }
        }
        
        return stack.peekFirst()
    }
}