class Solution {
    fun climbStairs(n: Int): Int {
        var currWays = 1
        var prevWays = 1
        
        for (i in (n - 2) downTo 0) {
            val totalWays = currWays + prevWays
            currWays = prevWays
            prevWays = totalWays
        }
        
        return prevWays
    }
}