// It took me 16 minutes to come up with my own solution:
class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n < 0) return false
        return Integer.toBinaryString(n).toCharArray().filter { it == '1' }.size == 1
    }
}

class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && Integer.bitCount(n) == 1
    }
}
