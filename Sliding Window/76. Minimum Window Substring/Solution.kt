class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""

        val tCharCount = HashMap<Char, Int>()
        for (char in t) {
            tCharCount[char] = (tCharCount[char] ?: 0) + 1
        }

        var have = 0
        var need = tCharCount.size
        
        var resStart = -1
        var resEnd = -1
        var resLength = Int.MAX_VALUE
        

        val window = HashMap<Char, Int>()
        var left = 0
        for (right in s.indices) {
            val char = s[right]
            window[char] = (window[char] ?: 0) + 1

            if (tCharCount[char] != null && window[char] == tCharCount[char]) {
                have++
            }

            while (have == need) {
                val length = right - left + 1
                if (length < resLength) {
                    resStart = left
                    resEnd = right
                    resLength = length
                }

                window[s[left]] = (window[s[left]] ?: 0) - 1

                if (tCharCount[s[left]] != null && (window[s[left]] ?: 0) < tCharCount[s[left]]!!) {
                    have--
                }
                left++
            }
        }

        return when {
            resStart == -1 || resEnd == -1 -> ""
            else -> s.substring(resStart, resEnd + 1)
        }
    }
}