class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if (total == target) {
                res.add(cur.toList()) // add a copy of the cur list into res
                return
            }

            if (i >= candidates.size || total > target) {
                return
            }

            cur.add(candidates[i])
            dfs(i, cur, total + candidates[i])
            
            cur.removeAt(cur.lastIndex)
            dfs(i + 1, cur, total)
        }

        dfs(0, mutableListOf(), 0)

        return res
    }
}