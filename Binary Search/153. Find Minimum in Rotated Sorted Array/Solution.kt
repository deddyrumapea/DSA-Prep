class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        
        var min = nums[0]
        
        while (left <= right) {
            if (nums[left] < nums[right]) { // we're in a sorted sub array
                min = Math.min(min, nums[left])
                break
            }
            
            val mid = left + (right - left) / 2
            min = Math.min(min, nums[mid])
            
            if (nums[mid] >= nums[left]) left = mid + 1
            else right = mid - 1
        }
        
        return min
    }
}