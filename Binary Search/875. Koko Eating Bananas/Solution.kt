class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var maxPile = 0
        for (pile in piles) maxPile = Math.max(maxPile, pile)
        
        var left = 1
        var right = maxPile
        
        var minK = maxPile
        
        while (left <= right) {
            val k = left + (right - left) / 2
            
            var hours = 0.0
            for (pile in piles) hours += Math.ceil(pile.toDouble() / k)
            
            if (hours <= h) {
                minK = Math.min(minK, k)
                right = k - 1
            } else {
                left = k + 1
            }
        }
        
        return minK
    }
}   