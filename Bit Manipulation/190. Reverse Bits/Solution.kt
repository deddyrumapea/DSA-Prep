class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n:Int): Int {
        var result = 0
        
        for (i in 0..31) {
            val bit = (n shr i) and 1 // Get the i-th bit using "and 1"
            result = result or (bit shl (31 - i)) // Put the bit using "or" in the reversed order
        }
        
        return result
    }
}