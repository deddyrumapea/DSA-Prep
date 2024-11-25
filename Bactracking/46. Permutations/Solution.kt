class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val mNums = nums.toMutableList()

        if (mNums.size == 1) return listOf(mNums)

        repeat (mNums.count()) {
            val num = mNums.removeAt(0)
            val perms = permute(mNums.toIntArray())
                .map { it.toMutableList().apply { add(num) } }
            result.addAll(perms)
            mNums.add(num)
        }

        return result
    }
}
