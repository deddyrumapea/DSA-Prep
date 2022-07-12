// Arithmetic solution
class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum1 = 0
        var sum2 = 0
        
        for (i in 0..nums.size) sum1 += i
        for (num in nums) sum2 += num
        
        return sum1 - sum2
    }
}

// Single pass with Gauss' summation formula
class Solution {
    fun missingNumber(nums: IntArray): Int {
        val sum1 = (nums.size * (1 + nums.size) / 2)
        var sum2 = 0
        for (num in nums) sum2 += num
        
        return sum1 - sum2
    }
}

class Solution {
    fun missingNumber(nums: IntArray): Int {
        var result = nums.size
        for (i in nums.indices) result += (i - nums[i])
        return result
    }
}

// Bit manipulation solution
class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum1 = 0
        var sum2 = 0
        
        for (i in 0..nums.size) sum1 = sum1 xor i
        for (num in nums) sum2 = sum2 xor num
        
        return sum1 xor sum2
    }
}