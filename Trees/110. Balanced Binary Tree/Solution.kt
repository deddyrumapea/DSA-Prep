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
    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root).isBalanced
    }

    private fun dfs(node: TreeNode?): Result {
        if (node == null) return Result(isBalanced = true, height = 0)

        val left = dfs(node?.left)
        val right = dfs(node?.right)
        
        return Result(
            isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1),
            height = 1 + Math.max(left.height, right.height)
        )
    }

    private data class Result(
        val isBalanced: Boolean,
        val height: Int
    )
}