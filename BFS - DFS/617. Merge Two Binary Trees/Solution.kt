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
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return when {
            root1 == null -> root2
            root2 == null -> root1
            else -> {
                root1.`val` += root2.`val`
                root1.left = mergeTrees(root1.left, root2.left)
                root1.right = mergeTrees(root1.right, root2.right)
                root1
            }
        }
    }
}