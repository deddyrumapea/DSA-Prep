// Time complexity: O(s + t + s) = O(n)
// Space complexity: O(26) = O(1)
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val charCount = MutableList<Int>(26) { 0 }
        for (char in s) charCount[char - 'a']++
        for (char in t) charCount[char - 'a']--
        for (count in charCount) if (count != 0) return false
        return true
    }
}

// Time complexity: O(s + s) = O(n)
// Space complexity: O(s) = O(n)
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val countS = mutableMapOf<Char, Int>()
        val countT = mutableMapOf<Char, Int>()

        for (i in s.indices) {
            countS[s[i]] = 1 + (countS[s[i]] ?: 0)
            countT[t[i]] = 1 + (countT[t[i]] ?: 0)
        }

        for (entry in countT) {
            if (countS[entry.key] != entry.value) return false
        }

        return true
    }
}
