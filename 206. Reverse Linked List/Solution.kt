/**
 * Example: var li = ListNode(5) var v = li.`val` Definition for singly-linked list. class
 * ListNode(var `val`: Int) {
 * ```
 *     var next: ListNode? = null
 * ```
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var backwardHead: ListNode? = null
        var forwardHead = head
        while (forwardHead != null) {
            val nextForwardHead = forwardHead.next
            forwardHead.next = backwardHead
            backwardHead = forwardHead
            forwardHead = nextForwardHead
        }
        return backwardHead
    }
}

/**
 * Example: var li = ListNode(5) var v = li.`val` Definition for singly-linked list. class
 * ListNode(var `val`: Int) {
 * ```
 *     var next: ListNode? = null
 * ```
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return reverseListInt(forwardHead = head, backwardHead = null)
    }

    private fun reverseListInt(forwardHead: ListNode?, backwardHead: ListNode?): ListNode? {
        if (forwardHead == null) return backwardHead
        val nextForwardHead = forwardHead.next
        forwardHead.next = backwardHead
        return reverseListInt(nextForwardHead, forwardHead)
    }
}
