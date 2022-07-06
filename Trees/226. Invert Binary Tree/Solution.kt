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

// Recursive solution
// 05/07/2022
// Solved in < 9 mins
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root?.left == null && root?.right == null) return root
        val temp = root?.left
        root?.left = root?.right
        root?.right = temp

        root?.left = invertTree(root?.left)
        root?.right = invertTree(root?.right)
        return root
    }
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return root

        root.left = invertTree(root.right).also {
            root.right = invertTree(root.left)
        }

        return root        
    }
}