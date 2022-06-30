// https://www.youtube.com/watch?v=_Ipng-tBpSw
class Solution {
    fun letterCasePermutation(s: String): List<String> {
        var results = mutableListOf<String>("")

        for (char in s) {
            val temp = mutableListOf<String>()
            if (char.isLetter()) {
                for (result in results) {
                    temp.add(result + char.toLowerCase())
                    temp.add(result + char.toUpperCase())
                }
            } else {
                for (result in results) {
                    temp.add(result + char)
                }
            }

            results = temp
        }

        return results
    }
}

/*
        a1b2   i=0, when it's at a, since it's a letter, we have two branches: a, A
        /     \
    a1b2       A1b2 i=1 when it's at 1, we only have 1 branch which is itself
    |          |
    a1b2       A1b2 i=2 when it's at b, we have two branches: b, B
    /  \        / \
    a1b2 a1B2  A1b2 A1B2 i=3  when it's at 2, we only have one branch.
    |    |     |     |
    a1b2 a1B2  A1b2  A1B2 i=4 = S.length(). End recursion, add permutation to ans.

    During this process, we are changing the S char array itself
*/
class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val ans = mutableListOf<String>()
        backtrack(ans, 0, s.toCharArray())
        return ans
    }

    private fun backtrack(ans: MutableList<String>, i: Int, s: CharArray) {
        if (i == s.size) {
            ans.add(String(s))
            return
        }

        if (s[i].isLetter()) {
            s[i] = s[i].toUpperCase()
            backtrack(ans, i + 1, s)
            s[i] = s[i].toLowerCase()
            backtrack(ans, i + 1, s)
        } else {
            backtrack(ans, i + 1, s)
        }
    }
}
