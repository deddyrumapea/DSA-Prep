class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charMap = HashMap<Char, Int>()
        var left = 0
        var right = 0
        var result = 0

        while (left < s.length && right < s.length) {
            val currentChar = s[right]
            if (charMap.contains(currentChar)) {
            	left = Math.max(left, charMap[currentChar]?.plus(1) ?: 0)
            }

            charMap[currentChar] = right
            result = Math.max(result, right - left + 1)
            right++
        }

        return result
    }
}