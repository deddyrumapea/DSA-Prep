class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] < target) left = mid + 1
            else right = mid - 1
        }

        return -1
    }
}