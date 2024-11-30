class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()

        val pCount = mutableMapOf<Char, Int>()
        val sCount = mutableMapOf<Char, Int>()

        for (i in p.indices) {
            pCount[p[i]] = (pCount[p[i]] ?: 0) + 1
            sCount[s[i]] = (sCount[s[i]] ?: 0) + 1
        }

        val result = mutableListOf<Int>()

        if (sCount == pCount) {
            result.add(0)
        }

        var left = 0
        for (right in (p.lastIndex + 1)..s.lastIndex) {
            sCount[s[right]] = (sCount[s[right]] ?: 0) + 1
            sCount[s[left]]?.let { sCount[s[left]] = it - 1 }

            if (sCount[s[left]] == 0) {
                sCount.remove(s[left])
            }
            
            ++left

            if (sCount == pCount) {
                result.add(left)
            }
        }

        return result
    }
}