// 2022/07/02
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun isPalindrome(s: String): Boolean {
        val newStr = s.toCharArray().filter { it.isLetterOrDigit() }
        for (i in newStr.indices) {
            val char1 = newStr[i].toLowerCase()
            val char2 = newStr[newStr.lastIndex - i].toLowerCase()
            if (!char1.isLetterOrDigit() || !char2.isLetterOrDigit()) continue
            if (!char1.equals(char2)) return false
        }

        return true
    }
}

// 2022/07/02
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex

        while (left <= right) {
            if (!s[left].isAlphaNum()) {
                ++left
                continue
            }

            if (!s[right].isAlphaNum()) {
                --right
                continue
            }

            if (s[left].toLowerCase() != s[right].toLowerCase()) return false

            ++left
            --right
        }
        return true
    }

    private fun Char.isAlphaNum(): Boolean {
        return this.toInt() in 'A'.toInt()..'Z'.toInt() ||
                this.toInt() in 'a'.toInt()..'z'.toInt() ||
                this.toInt() in '0'.toInt()..'9'.toInt()
    }
}
