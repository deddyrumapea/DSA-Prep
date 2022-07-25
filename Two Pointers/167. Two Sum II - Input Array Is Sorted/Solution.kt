class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex
        
        while ((numbers[left] + numbers[right]) != target) {
            if ((numbers[left] + numbers[right]) < target) ++left
            else --right
        }
        
        return intArrayOf(left + 1, right + 1)
    }
}