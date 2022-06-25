class Solution {
    fun moveZeroes1(nums: IntArray): Unit {
        var zeroesCount = 0
        val result = mutableListOf<Int>()
        
        for (num in nums) {
            if (num == 0) zeroesCount++
            else result.add(num)
        }
        
        for (i in 1..zeroesCount){
            result.add(0)
        }
        
        
        for (i in nums.indices){
            nums[i] = result[i]
        }
    }

    fun moveZeroes2(nums: IntArray): Unit {
        var lastNonZeroFoundAt = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt] = nums[i].also {
                    nums[i] = nums[lastNonZeroFoundAt]
                }
                lastNonZeroFoundAt++
            }
        }
    }

    fun moveZeroes3(nums: IntArray): Unit {
        var nonZeroesCount = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[nonZeroesCount++] = nums[i]
            }
        }
        
        for (i in (nonZeroesCount)..nums.lastIndex) {
            nums[i] = 0
        }
    }
}