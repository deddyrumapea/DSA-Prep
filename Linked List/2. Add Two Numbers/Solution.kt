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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var tail = head
        
        var carry = 0
        
        var list1 = l1
        var list2 = l2
        while (list1 != null || list2 != null || carry > 0) {
            val num1 = list1?.`val` ?: 0
            val num2 = list2?.`val` ?: 0
            
            var sum = num1 + num2
            
            if (carry > 0) {
                ++sum
                --carry
            }
            
            if (sum > 9) {
                sum -= 10
                ++carry
            }
            
            tail.next = ListNode(sum)
            tail = tail.next
            
            list1 = list1?.next
            list2 = list2?.next
        }
        
        return head.next
    }
}