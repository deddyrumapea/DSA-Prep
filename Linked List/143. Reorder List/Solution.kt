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
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head?.next

        // find middle node
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next.next
        }
        val mid = slow

        var l1 = head
        var l2 = mid?.next
        mid?.next = null

        // reverse second portion of the linked list
        var prev: ListNode? = null
        while (l2 != null) {
            val next = l2.next
            l2.next = prev
            prev = l2
            l2 = next
        }
        l2 = prev

        // splice between first portion and reversed second portion
        while (l1 != null && l2 != null) {
            val next1 = l1.next
            val next2 = l2.next

            l1.next = l2
            l2.next = next1
            l1 = next1
            l2 = next2
        }
    }
}
