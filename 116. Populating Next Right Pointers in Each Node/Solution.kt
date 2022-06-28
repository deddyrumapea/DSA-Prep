/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        dfs(root, null)
        return root
    }

    private fun dfs(current: Node?, next: Node?) {
        if (current == null) return
        current.next = next
        dfs(current.left, current.right)
        dfs(current.right, current.next?.left)
    }
}