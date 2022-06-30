class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val mNums = nums.toMutableList()

        if (mNums.size == 1) return listOf(mNums.toList())

        for (i in mNums.indices) {
            val n = mNums.removeAt(0)
            val perms = permute(mNums.toIntArray()).map { it.toMutableList().apply { add(n) } }
            result.addAll(perms)
            mNums.add(n)
        }

        return result
    }
}
