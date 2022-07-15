// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numFreq = HashMap<Int, Int>()
        val freqNum = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
        val result = mutableListOf<Int>()
        
        for (num in nums) numFreq[num] = 1 + (numFreq[num] ?: 0)
        for (entry in numFreq) freqNum[entry.value].add(entry.key)
        for (i in freqNum.lastIndex downTo 0) {
            for (num in freqNum[i]) {
                result.add(num)
                if (result.size == k) return result.toIntArray()
            }
        }
        
        return result.toIntArray()
    }
}