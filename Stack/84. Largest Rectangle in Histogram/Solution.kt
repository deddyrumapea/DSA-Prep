class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = ArrayDeque<Pair<Int, Int>>() // Pair of index to height

        heights.forEachIndexed { i, h ->
            var startIndex = i
            while (stack.isNotEmpty() && h < stack.last().second) {
                val (index, height) = stack.removeLast()
                maxArea = maxOf(maxArea, height * (i - index))
                startIndex = index
            }
            stack.addLast(startIndex to h)
        }

        val n = heights.size
        for ((i, h) in stack) {
            maxArea = maxOf(maxArea, h * (n - i))
        }

        return maxArea
    }
}