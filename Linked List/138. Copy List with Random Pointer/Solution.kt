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
        val oldToCopy = mutableMapOf<Node, Node>()
        
        var oldNode = node
        while (oldNode != null) {
            oldToCopy[oldNode] = Node(oldNode.`val`)
            oldNode = oldNode.next
        }
        
        for (entry in oldToCopy) {
            entry.value.next = oldToCopy[entry.key.next]
            entry.value.random = oldToCopy[entry.key.random]
        }
        
        return oldToCopy[node]
    }
}