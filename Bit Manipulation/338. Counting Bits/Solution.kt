// Solved in ~16 minutes
class Solution {
    fun countBits(n: Int): IntArray {
        return List<Int>(n + 1) { i -> 
            numOfOnes(i) 
        }.toIntArray()
    }
    
    private fun numOfOnes(n: Int): Int {
        var result = 0
        var num = n
        
        while (num != 0) {
            num = num and (num - 1)
            ++result
        }
        
        return result
    }
}

class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1) { 0 }
        var offset = 1
        
        for (i in 1..n) { // Skip zero because it doesn't have any 1s
            if (i == offset * 2) offset = i // Everytime i is double the offset, update the offset
            result[i] = 1 + result[i - offset]
        }
        
        return result
    }
}