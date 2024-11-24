/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        val originalToCopy = mutableMapOf<Node, Node>()

        var originalNode = node
        while (originalNode != null) {
            originalToCopy[originalNode] = Node(originalNode.`val`)
            originalNode = originalNode.next
        }

        for ((original, copy) in originalToCopy) {
            copy.next = originalToCopy[original.next]
            copy.random = originalToCopy[original.random]
        }

        return originalToCopy[node]
    }
}
