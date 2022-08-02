class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val seenChars = mutableSetOf<Char>()
        var left = 0
        
        for (right in s.indices) {
            while (seenChars.contains(s[right])) {
                seenChars.remove(s[left])
                ++left
            }
            seenChars.add(s[right])
            maxLength = Math.max(maxLength, right - left + 1)
        }
        
        return maxLength
    }
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()
        var left = 0
        var right = 0
        var maxLength = 0
        
        while (right <= s.lastIndex) {
            while (charSet.contains(s[right])) {
                charSet.remove(s[left])
                ++left
            }
            charSet.add(s[right])
            val currLength = right - left + 1
            maxLength = Math.max(maxLength, currLength)
            ++right
        }
        
        return maxLength
    }
}