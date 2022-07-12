/*
    2022/07/04
    Iterative solution
    Time complexity: O(n)
    Space complexity: O(1)
*/
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            val next = current.next // Temporary variable
            current.next = prev // Re-reference next pointer to previous node
            prev = current // Shift previous to current
            current = next // Shift current to next
        }

        return prev // At this point, prev will contain the last node of the original list
    }
}

/*
    2022/07/04
    Recursive solution
    Time complexity: O(n)
    Space complexity: O(n)
*/
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return reverse(current = head, prev = null) // Return reversed list head
    }

    private fun reverse(
        current: ListNode?, 
        prev: ListNode?
    ): ListNode? {
        if (current == null) return prev // If it's at the end of the list, return prev head
        val next = current.next // Temporary variable
        current.next = prev // Re-reference next pointer to previous node
        return reverse(current = next, prev = current) // Shift current to next and prev to current
    }
}

/*
    2022/07/04
    Recursive solution
    Time complexity: O(n)
    Space complexity: O(n)
*/
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null
        var newHead = head
        if (head.next != null) {
            newHead = reverseList(head.next)
            head.next.next = head
            head.next = null
        }
        return newHead
    }
}