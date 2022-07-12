class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        
        for (char in s) {
            when {
                char == ')' && stack.peekLast() == '(' -> stack.removeLast()
                char == '}' && stack.peekLast() == '{' -> stack.removeLast()
                char == ']' && stack.peekLast() == '[' -> stack.removeLast()
                else -> stack.addLast(char)
            }
        }
        
        return stack.size == 0
    }
}