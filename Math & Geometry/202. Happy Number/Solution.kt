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
            
            if (sumOfSquares == 1) return true
            else num = sumOfSquares
        }

        return false
    }
}

// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun isHappy(n: Int): Boolean {
        val checked = mutableSetOf<Int>()
        var num = n
        
        while (!checked.contains(num)) {
            checked.add(num)
            
            val sumOfSquares = sumOfSquares(num) 
            
            if (sumOfSquares == 1) return true
            else num = sumOfSquares
        }

        return false
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

    private fun sumOfSquares(num: Int): Int {
        var mNum = num
        var sum = 0
        
        while (mNum > 0) {
            val digit = mNum % 10
            sum += digit * digit
            mNum = mNum / 10
        }

        return sum
    }
}