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
        val newHead = ListNode(0).apply{ next = head }
        var slow = newHead
        var fast = newHead
        
        for (i in 1..n) {
            fast = fast?.next
        }
        
        while (fast?.next != null){
            fast = fast?.next
            slow = slow?.next
        }
        
        slow?.next = slow?.next?.next
        
        return newHead?.next
    }
}