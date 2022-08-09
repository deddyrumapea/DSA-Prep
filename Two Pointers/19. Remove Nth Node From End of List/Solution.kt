/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummyNode = ListNode(0)
        dummyNode.next = head
        
        var left = dummyNode
        var right = dummyNode
        
        for (i in 0..(n - 1)) right = right?.next
        
        while (right?.next != null) {
            left = left?.next
            right = right?.next
        }
        
        left?.next = left?.next?.next
                
        return dummyNode.next
    }
}