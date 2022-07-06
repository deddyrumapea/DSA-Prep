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

// Solved in ~12 minutes
// Recursive solution
// Brute force
// Time complexity: O(root * subRoot) = O(n^2) 
// Space complexity: O(root) = O(n)
class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null) return true
        if (root == null) return false
        
        return isSameTree(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }
    
    private fun isSameTree(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) return true
        if (t1?.`val` != t2?.`val`) return false
        
        val isLeftSame = isSameTree(t1?.left, t2?.left)
        val isRightSame = isSameTree(t1?.right, t2?.right)
        
        return isLeftSame && isRightSame
    }
}