class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()

        if (s.length > 12) {
            return result
        }

        fun backtrack(i: Int, dots: Int, curIp: String) {
            if (dots > 4) {
                return
            }

            if (dots == 4 && i > s.lastIndex) {
                result.add(curIp.substring(0, curIp.lastIndex)) // remove last char '.'
                return
            }

            for (j in i..minOf(i + 3, s.lastIndex)) {
                if (s.substring(i, j + 1).toInt() <= 255 && (i == j || s[i] != '0')) {
                    backtrack(j + 1, dots + 1, curIp + s.substring(i, j + 1) + ".")
                }
            }
        }

        backtrack(0, 0, "")

        return result
    }
}