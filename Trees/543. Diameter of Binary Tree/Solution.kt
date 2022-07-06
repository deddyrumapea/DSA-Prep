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
class Solution {
    // Record the longest path length (diameter) as a global variable
    // because it may or may not pass through the root node
    var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        getDeepestPathLength(root) // Start DFS
        return diameter
    }

    fun getDeepestPathLength(node: TreeNode?): Int {
        if (node == null) return 0

        val left = getDeepestPathLength(node.left) // Get deepest path length from left node
        val right = getDeepestPathLength(node.right) // Get deepest path length from right node

        diameter = Math.max(diameter, left + right) // Record the max diameter

        return 1 + Math.max(left, right) // +1 because current node is not null, so it counts
    }
}