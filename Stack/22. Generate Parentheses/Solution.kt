class Solution {
    private val stack = ArrayDeque<Char>()
    private val result = mutableListOf<String>()
    
    fun generateParenthesis(n: Int): List<String> {
        backtrack(0, 0, n)
        return result
    }
    
    private fun backtrack(openCount: Int, closedCount: Int, limitCount: Int) {
        if (openCount == closedCount && closedCount == limitCount) {
            result.add(stack.joinToString(""))
            return
        }
        
        if (openCount < limitCount) {
            stack.addLast('(')
            backtrack(openCount + 1, closedCount, limitCount)
            stack.removeLast()
        }
        
        if (closedCount < openCount) {
            stack.addLast(')')
            backtrack(openCount, closedCount + 1, limitCount)
            stack.removeLast()
        }
    }
}