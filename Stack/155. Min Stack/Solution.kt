class MinStack() {

    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        minStack.add(
            if (minStack.size > 0) Math.min(`val`, minStack.last()) 
            else `val`
        )
    }

    fun pop() {
        stack.removeAt(stack.lastIndex)
        minStack.removeAt(minStack.lastIndex)
    }

    fun top(): Int = stack[stack.lastIndex]

    fun getMin(): Int = minStack[minStack.lastIndex]
}

/**
 * Your MinStack object will be instantiated and called as such: var obj = MinStack()
 * obj.push(`val`) obj.pop() var param_3 = obj.top() var param_4 = obj.getMin()
 */
class MinStack() {
    private var head: Node? = null

    fun push(`val`: Int) {
        head = if (head == null) Node(`val` = `val`, min = `val`)
        else Node(
            `val` = `val`, 
            min = Math.min(`val`, head?.min ?: Int.MAX_VALUE), 
            next = head
        )
    }

    fun pop() {
        head = head?.next
    }

    fun top(): Int = head?.`val` ?: 0

    fun getMin(): Int = head?.min ?: 0

    private inner class Node(
        val `val`: Int, 
        val min: Int, 
        val next: Node? = null
    )
}

/**
 * Your MinStack object will be instantiated and called as such: var obj = MinStack()
 * obj.push(`val`) obj.pop() var param_3 = obj.top() var param_4 = obj.getMin()
 */
