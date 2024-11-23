class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        
        for (char in s) {
            when {
                char == ')' && stack.lastOrNull() == '(' -> stack.removeLast()
                char == '}' && stack.lastOrNull() == '{' -> stack.removeLast()
                char == ']' && stack.lastOrNull() == '[' -> stack.removeLast()
                else -> stack.addLast(char)
            }
        }
        
        return stack.size == 0
    }
}
