/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

// Solved in 4:20
// Recursive solution
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p?.`val` != q?.`val`) return false

        val isLeftSame = isSameTree(p?.left, q?.left)
        val isRightSame = isSameTree(p?.right, q?.right)

        return isLeftSame && isRightSame
    }
}