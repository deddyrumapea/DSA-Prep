class Solution {
    fun maxProfit(prices: IntArray): Int {
        var buyIndex = 0
        var sellIndex = 0
        var maxP = 0
        
        while(sellIndex <= prices.lastIndex) {
            if (prices[sellIndex] < prices[buyIndex]) buyIndex = sellIndex
            maxP = Math.max(prices[sellIndex] - prices[buyIndex], maxP)
            ++sellIndex
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
