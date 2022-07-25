class Solution {
    fun maxArea(height: IntArray): Int {
        var result = 0
        
        var left = 0
        var right = height.lastIndex
        
        while (left < right) {
            val currArea = Math.min(height[left], height[right]) * (right - left)
            result = Math.max(result, currArea)
            
            if (height[left] < height[right]) ++left
            else --right   
        }
        
        return result
    }
}