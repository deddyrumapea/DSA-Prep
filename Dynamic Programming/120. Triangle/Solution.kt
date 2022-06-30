class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val curMinPath = MutableList<Int>(triangle.last().size + 1) { 0 }

        for (row in triangle.reversed()) {
            row.forEachIndexed { i, num ->
                val minChild = Math.min(curMinPath[i], curMinPath[i + 1])
                curMinPath[i] = num + minChild
            }
        }

        return curMinPath[0]
    }
}
