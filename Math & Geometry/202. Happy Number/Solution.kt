// Solved in ~21 minutes
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun isHappy(n: Int): Boolean {
        val checked = mutableSetOf<Int>()
        var num = n

        while (!checked.contains(num)) {
            checked.add(num)
            
            var sumOfSquares = 0
            for (digit in num.toString()) {
                val intDigit = digit.toString().toInt()
                sumOfSquares += (intDigit * intDigit)
            }

            when (sumOfSquares == 1) {
                true -> return true
                false -> num = sumOfSquares
            } 
        }

        return false
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n
        var fast = sumOfSquares(n)

        while (fast != 1) {
            if (slow == fast) return false
            slow = sumOfSquares(slow)
            fast = sumOfSquares(sumOfSquares(fast))
        }

        return true
    }

    private fun sumOfSquares(n: Int): Int {
        var num = n
        var sum = 0

        while (num > 0) {
            val digit = num % 10
            sum += digit * digit
            num = num / 10
        }

        return sum
    }
}
