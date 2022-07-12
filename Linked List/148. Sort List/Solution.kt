// Solved in 21 minutes
// Using merge sort
// Time complexity: O(n*log(n))
// Space complexity: O(n*log(n))
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
    fun sortList(head: ListNode?): ListNode? {
        val list = mutableListOf<Int>()
        var head = head
        while (head != null) {
            list.add(head.`val`)
            head = head.next
        }
        
        val merged = mergeSort(list)
        var resultTail = ListNode(0)
        val resultHead = resultTail
        for (element in merged) {
            resultTail.next = ListNode(element)
            resultTail = resultTail.next
        }
        
        return resultHead.next
    }

    private fun mergeSort(list: List<Int>): List<Int> {
        if (list.size <= 1) return list

        val mid = list.size / 2

        val left = mergeSort(list.subList(0, mid))
        val right = mergeSort(list.subList(mid, list.size))

        return merge(left, right)
    }
        
    private fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var leftIndex = 0
        var rightIndex = 0

        val result = mutableListOf<Int>()

        while (leftIndex <= left.lastIndex && rightIndex <= right.lastIndex) {
            when {
                left[leftIndex] < right[rightIndex] -> {
                    result.add(left[leftIndex])
                    ++leftIndex
                }

                right[rightIndex] < left[leftIndex] -> {
                    result.add(right[rightIndex])
                    ++rightIndex
                }

                else -> {
                    result.add(left[leftIndex])
                    result.add(right[rightIndex])
                    ++leftIndex
                    ++rightIndex
                }
            }
        }

        if (rightIndex > right.lastIndex) {
            result.addAll(left.subList(leftIndex, left.size))
        } else {
            result.addAll(right.subList(rightIndex, right.size))
        }

        return result
    }
}


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
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        val left = head
        val mid = getMiddleNode(head)
        val right = mid?.next
        mid?.next = null // Cut the middle link, so left section won't include right section

        return merge(sortList(left), sortList(right))
    }

    private fun getMiddleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next

        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        return slow
    }

    private fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        val head = ListNode(0)
        var tail = head

        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            when {
                l1.`val` < l2.`val` -> {
                    tail.next = l1
                    tail = tail.next
                    l1 = l1.next
                }

                l1.`val` > l2.`val` -> {
                    tail.next = l2
                    tail = tail.next
                    l2 = l2.next
                }

                else -> {
                    tail.next = l1
                    tail = tail.next
                    l1 = l1.next

                    tail.next = l2
                    tail = tail.next
                    l2 = l2.next
                }
            }
        }

        tail.next = if (l1 == null) l2 else l1

        return head.next
    }
}