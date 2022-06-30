class Solution {
    fun climbStairs(n: Int): Int {
        var one = 1
        var two = 0

        for (i in 1..n) {
            val temp = one
            one += two
            two = temp
        }

        return one
    }
}
