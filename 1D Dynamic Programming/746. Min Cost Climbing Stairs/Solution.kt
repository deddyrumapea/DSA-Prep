// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        for (i in cost.lastIndex - 2 downTo 0) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2])
        }
        
        return Math.min(cost[0], cost[1])
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val cost = cost.toMutableList()
        cost.add(0)
        
        for (i in (cost.lastIndex - 3) downTo 0) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2])
        }
        
        return Math.min(cost[0], cost[1])
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.size == 2) return Math.min(cost[0], cost[1])

        var first = cost[0]
        var second = cost[1]

        for (i in 2..cost.lastIndex) {
            val total = cost[i] + Math.min(first, second)
            first = second
            second = total
        }

        return Math.min(first, second)
    }
}