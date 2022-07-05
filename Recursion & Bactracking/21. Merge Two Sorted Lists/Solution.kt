/**
 * Example: var li = ListNode(5) var v = li.`val` Definition for singly-linked list. class
 * ListNode(var `val`: Int) {
 * ```
 *     var next: ListNode? = null
 * ```
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var tail = ListNode(0) // Used as a reference to merged list, init with dummy node
        val head = tail // Used as a reference to the starting node

        var l1 = list1 // Create mutable variable for list1
        var l2 = list2 // Create mutable variable for list2

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                tail.next = l1 // Reference l1 as the next node of tail
                l1 = l1.next // Move to the next l1 node
            } else {
                tail.next = l2 // Reference l1 as the next node of tail
                l2 = l2.next // Move to the next l2 node
            }

            // After the next node of tail is referenced,
            // move tail to the next node
            tail = tail.next 
        }

        // If either of the lists is already run out of node, 
        // reference the next node of tail to the other list
        tail.next = if (l1 == null) l2 else l1

        return head.next // Return next because the first node is a dummy node
    }
}