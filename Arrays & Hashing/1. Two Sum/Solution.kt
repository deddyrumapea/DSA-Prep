// 2022/07/02
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numIndex = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val result = numIndex[target - nums[i]]
            if (result != null) return intArrayOf(i, result)
            numIndex[nums[i]] = i
        }

        return intArrayOf()
    }
}

// My very old answer
// Time complexity: O(n^2)
// Space complexity: O(1)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var result = intArrayOf(0, 0)

        for (i in 0..nums.lastIndex) {
            for (j in (i + 1)..nums.lastIndex) {
                if ((nums[i] + nums[j]) == target) result = intArrayOf(i, j)
            }
        }

        return result
    }
}
