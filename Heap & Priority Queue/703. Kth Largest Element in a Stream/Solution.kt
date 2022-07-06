class KthLargest(private val k: Int, nums: IntArray) {
    private val queue = PriorityQueue<Int>(k)

    init {
        for (num in nums) add(num)
    }

    fun add(`val`: Int): Int {
        when {
            queue.size < k -> queue.offer(`val`)
            queue.peek() < `val` -> {
                queue.poll()
                queue.offer(`val`)
            }
        }
        return queue.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */