class Solution {
    fun climbStairs(n: Int): Int {
        var currWays = 1
        var prevWays = 1

        repeat (n - 1) {
            val totalWays = currWays + prevWays
            currWays = prevWays
            prevWays = totalWays
        }

        return prevWays
    }
}
