class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0

        var left = 0
        var right = 1
        var maxP = 0

        while (right <= prices.lastIndex) {
            if (prices[left] < prices[right]) {
                maxP = Math.max(maxP, prices[right] - prices[left])
            } else {
                left = right
            }

            ++right
        }

        return maxP
    }
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buy = Int.MAX_VALUE
        var sell = 0

        for (i in prices.indices) {
            buy = Math.min(buy, prices[i])
            sell = Math.max(sell, prices[i] - buy)
        }

        return sell
    }
}
