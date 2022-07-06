// Solved in ~8 minutes
// Iterative solution
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>(stones.size) { i: Int, j: Int -> j - i } // Create a max heap
        queue.addAll(stones.toList())
        
        while (queue.size > 1) {
            val num1 = queue.poll()
            val num2 = queue.poll()
            val result = num1 - num2
            
            if (result > 0) queue.offer(result)
        }
        
        return queue.peek() ?: 0
    }
}