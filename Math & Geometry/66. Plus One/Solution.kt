// Solved in ~15 minutes
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        ++digits[digits.lastIndex]
        var carry = 0

        for (i in digits.lastIndex downTo 0) {
            if (carry > 0) {
                ++digits[i]
                --carry
            }

            if (digits[i] > 9) {
                digits[i] -= 10
                ++carry
            }
        }

        return when (carry > 0) {
            true -> intArrayOf(carry, *digits)
            false -> digits
        }
    }
}
