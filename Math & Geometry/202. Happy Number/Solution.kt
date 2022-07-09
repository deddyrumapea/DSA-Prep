// Solved in ~21 minutes
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

// TODO: add Floyd's cycle finding algorithm here