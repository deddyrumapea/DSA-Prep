class Solution {
    fun rotate(nums: IntArray, k: Int): IntArray {
        val oldNums = nums.clone()
        nums.forEachIndexed { index, element ->
            nums[(index + k % nums.size) % nums.size] = oldNums[index]
        }
        return nums
    }
}