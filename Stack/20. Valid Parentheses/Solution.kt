import java.util.ArrayDeque

class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (char in s) {
            when {
                char == ')' && stack.peek() == '(' -> stack.remove()
                char == '}' && stack.peek() == '{' -> stack.remove()
                char == ']' && stack.peek() == '[' -> stack.remove()
                setOf('(', '{', '[').contains(char) -> stack.push(char)
                else -> return false
            }
        }

        return stack.size == 0
    }
}
