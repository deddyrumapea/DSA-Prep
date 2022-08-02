class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val charFreq = IntArray(26) { 0 }
        var maxLength = 0
        
        var left = 0
        var right = 0
        
        for (right in s.indices) {
            ++charFreq[s[right] - 'A']
            
            var maxFreq = 0
            for (freq in charFreq) maxFreq = Math.max(maxFreq, freq)
            
            while (maxFreq + k < right - left + 1) {
                --charFreq[s[left] - 'A']
                ++left
            }
            
            maxLength = Math.max(maxLength, right - left + 1)
        }
        
        return maxLength
    }
}

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val charFreq = IntArray(26) { 0 }
        
        var maxFreq = 0
        var maxLength = 0
        
        var left = 0
        var right = 0
        
        while (right <= s.lastIndex) {
            maxFreq = Math.max(maxFreq, ++charFreq[s[right] - 'A'])
            
            if (right - left + 1 - maxFreq > k) {
                --charFreq[s[left] - 'A']
                ++left
            }
            
            maxLength = Math.max(maxLength, right - left + 1)
            
            ++right
        }
        
        return maxLength
    }
}