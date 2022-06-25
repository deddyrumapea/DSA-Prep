class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex
        
        while((numbers[left] + numbers[right]) != target) {
            if ((numbers[left] + numbers[right]) > target) right-- 
            else left++
        }
        
        return intArrayOf(left + 1, right + 1)
    }

    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var index1 = 0
        var index2 = 0
        
        for (i in numbers.indices){
            for (j in (i + 1)..numbers.lastIndex){
                if ((numbers[i] + numbers[j]) == target){
                    index1 = i + 1
                    index2 = j + 1
                }
            }
        }
        
        return intArrayOf(index1, index2)
    }
}