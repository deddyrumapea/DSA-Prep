class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val queue = ArrayDeque<Int>()
        
        var left = 0
        var right = 0

        while (right < nums.size) {
            while (queue.isNotEmpty() && nums[queue.last()] < nums[right]) {
                queue.removeLast()
            }

            queue.addLast(right)

            if (left > queue.first()) {
                queue.removeFirst()
            }

            if ((right + 1) >= k) {
                result.add(nums[queue.first()])
                ++left
            }
            ++right
        }

        return result.toIntArray()
    }
}