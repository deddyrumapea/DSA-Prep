class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        
        while (left <= right) {
            val mid = left + ((right - left) / 2)
            if (nums[mid] == target) return mid
            if (target > nums[mid]) left = mid + 1
            else right = mid - 1
        }
        
        return -1
    }
}

/*
    For mid, use left + ((right - left) / 2) instead of (right + left) / 2 to avoid Integer overflow. Because it's possible that right + left is bigger than Int.MAX_VALUE

    Binary sarch only works for sorted values. That's why it's so efficient with O(log n) time complexity.
*/