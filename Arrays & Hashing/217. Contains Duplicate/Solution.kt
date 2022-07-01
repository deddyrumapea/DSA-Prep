class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.size != nums.distinct().size
    }
}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val uniqueNums = mutableSetOf<Int>()
        uniqueNums.addAll(nums.toList())
        return uniqueNums.size != nums.size
    }
}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val uniqueNums = mutableSetOf<Int>()
        nums.forEach { if (!uniqueNums.add(it)) return true }
        return false
    }
}