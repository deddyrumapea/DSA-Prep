class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val count = IntArray(26) { 0 }
        
        for (i in s1.indices) {
        	count[s1[i] - 'a']++
        	count[s2[i] - 'a']--
        }

        if (allZero(count)) return true

        for (i in (s1.length)..(s2.lastIndex)) {
        	count[s2[i] - 'a']--
        	count[s2[i - s1.length] - 'a']++
        	if (allZero(count)) return true
        }

        return false
    }

    private fun allZero(count: IntArray) : Boolean {
    	for (i in count) if (i != 0) return false 
    	return true
    }
}