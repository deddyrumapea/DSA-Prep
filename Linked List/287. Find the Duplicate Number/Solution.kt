class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)
        
        var slow2 = 0
        while (slow != slow2) {
            slow = nums[slow]
            slow2 = nums[slow2]
        }
        
        return slow
    }
}