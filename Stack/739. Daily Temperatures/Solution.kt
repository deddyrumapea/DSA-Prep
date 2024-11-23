// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val result = IntArray(temperatures.size)

        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val prevIndex = stack.removeLast()
                result[prevIndex] = i - prevIndex
            }

            stack.addLast(i)
        }

        return result
    }
}


// Brute Force solution
// Solved in ~15 minutes
// Time complexity = O(n ^ 2)
// Space complexity = O(n)
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        
        for (i in temperatures.indices) {
            for (j in (i + 1)..temperatures.lastIndex) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i
                    break
                } else if (j == temperatures.lastIndex) {
                    result[i] = 0
                    break
                }
            }
        }
        
        return result
    }
}
