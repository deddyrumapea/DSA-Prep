class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pairs = mutableListOf<Pair<Int, Int>>()
        for (i in position.indices) pairs.add(Pair(position[i], speed[i]))
        
        val stack = mutableListOf<Double>()
        
        for ((p, s) in pairs.sortedByDescending { it.first }) {
            val arrivalTime = (target - p) / s.toDouble()
            stack.add(arrivalTime)
            if (stack.size >= 2 && stack[stack.lastIndex] <= stack[stack.lastIndex - 1]) {
                stack.removeAt(stack.lastIndex)
            }
        }
        
        return stack.size
    }
}