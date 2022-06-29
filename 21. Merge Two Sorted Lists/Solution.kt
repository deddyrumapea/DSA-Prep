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
        var node = ListNode(0)
        var head = node

        var list1Head = list1
        var list2Head = list2

        while (list1Head != null || list2Head != null) {
            if (list2Head == null || ((list1Head != null) && (list1Head?.`val` < list2Head?.`val`))
            ) {
                node.next = list1Head
                list1Head = list1Head?.next
            } else {
                node.next = list2Head
                list2Head = list2Head?.next
            }
            node = node.next
        }

        return head.next
    }
}
