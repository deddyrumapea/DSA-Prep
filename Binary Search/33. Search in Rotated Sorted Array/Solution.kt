class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                nums[mid] == target -> return mid
                
                nums[left] <= nums[mid] -> { // left sorted portion
                    when (target in nums[left]..nums[mid]) {
                        true -> right = mid - 1
                        false -> left = mid + 1
                    }
                }

                else -> { // right sorted portion
                    when (target in nums[mid]..nums[right]) {
                        true -> left = mid + 1
                        false -> right = mid - 1
                    }
                }
            }
        }

        return -1
    }
}
