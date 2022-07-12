class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var curSum = 0
        var maxSum = nums[0]
        
        for (num in nums) {
            if (curSum < 0) curSum = 0
            curSum += num
            maxSum = Math.max(maxSum, curSum)
        }
        
        return maxSum
    }
}