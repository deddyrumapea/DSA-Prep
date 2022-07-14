// Time complexity: O(m * nlogn)
// Space complexity: O(n)
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = HashMap<String, MutableList<String>>()
        
        for (str in strs) {
            val sortedStr = str
                .toCharArray()
                .sorted()
                .joinToString("")
            
            if (groups[sortedStr] != null) groups[sortedStr]?.add(str)
            else groups[sortedStr] = mutableListOf(str)
        }
        
        return groups.map{ it.value }
    }
}

// Solved in ~15 minutes
// Time complexity: O(n^3) wtf
// Space complexity: O(n)
class Solution {
    private val groups = mutableListOf<MutableList<String>>()
    
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        for (str in strs) {
            var added = false

            for (i in groups.indices) {
                if (str.isAnagramOf(groups[i][0])) {
                    groups[i].add(str)
                    added = true
                    break
                }
            }
            
            if (!added) groups.add(mutableListOf(str))
        }
        
        return groups
    }
    
    private fun String.isAnagramOf(other: String): Boolean {
        if (this.length != other.length) return false
        
        val countThis = mutableMapOf<Char, Int>()
        val countOther = mutableMapOf<Char, Int>()
        
        for (i in this.indices) {
            countThis[this[i]] = 1 + (countThis[this[i]] ?: 0)
            countOther[other[i]] = 1 + (countOther[other[i]] ?: 0)
        }
        
        for (entry in countThis) {
            if (countOther[entry.key] != entry.value) return false
        }
        
        return true
    }
}