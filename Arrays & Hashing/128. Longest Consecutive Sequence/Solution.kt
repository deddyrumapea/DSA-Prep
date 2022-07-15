class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = mutableSetOf<Int>()
        numSet.addAll(nums.toList())

        var maxLength = 0

        for (num in nums) {
            if (!numSet.contains(num - 1)) {
                var length = 0
                while (numSet.contains(num + length)) ++length
                maxLength = Math.max(maxLength, length)
            }
        }       

        return maxLength
    }
}