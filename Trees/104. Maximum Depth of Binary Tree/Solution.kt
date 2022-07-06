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
// Solution 1: Recursive
// 2022/07/05
// Solved in < 3 mins
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = 1 + maxDepth(root.left) // +1 because current node is not null, thus it counts
        val right = 1 + maxDepth(root.right) // +1 because current node is not null, thus it counts
        return Math.max(left, right)
    }
}

// Simplified version of solution 1
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
    }
}

