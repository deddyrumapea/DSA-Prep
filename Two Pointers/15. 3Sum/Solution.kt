class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val sortedNums = nums.sorted()
        
        for (i in sortedNums.indices) {
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) continue
            
            var left = i + 1
            var right = sortedNums.lastIndex
            
            while (left < right) {
                val threeSum = sortedNums[i] + sortedNums[left] + sortedNums[right]
                
                when {
                    threeSum > 0 -> --right
                    threeSum < 0 -> ++left
                    else -> {
                        result.add(listOf(sortedNums[i], sortedNums[left++], sortedNums[right]))
                        while (sortedNums[left] == sortedNums[left - 1] && left < right) ++left
                    }
                }
            }
        }
        
        return result
    }
}