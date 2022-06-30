class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            result[index] = i * i
        }

        return result.apply { sort() }
    }

    fun sortedSquares2(nums: IntArray): IntArray {
	    val result = IntArray(nums.size)

	    var left = 0
	    var right = nums.lastIndex

	    for (i in nums.lastIndex downTo 0) {
	        if (Math.abs(nums[left]) > Math.abs(nums[right])) {
	            result[i] = nums[left] * nums[left]
	            left++
	        } else {
	            result[i] = nums[right] * nums[right]
	            right--
	        }
	    }
	    return result
	}
}