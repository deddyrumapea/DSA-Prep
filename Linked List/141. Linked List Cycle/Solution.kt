/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

// 12 mins
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val nodeSet = HashSet<ListNode>()
        var headNode = head
        
        while (headNode != null) {
            if (!nodeSet.add(headNode)) return true
            headNode = headNode.next
        }
        
        return false
    }
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var tortoise = head
        var hare = head?.next
 
        while (hare != null) {
            if (tortoise == hare) return true
            tortoise = tortoise?.next
            hare = hare?.next?.next
        }

        return false
    }
}