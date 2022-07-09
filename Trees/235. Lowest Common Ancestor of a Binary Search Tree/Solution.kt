/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

// important keyword: BINARY SEARCH TREE
// Iterative solution
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {        
        var ancestor = root
        while(ancestor != null) {
            when {
                p == null -> return q
                q == null -> return p
                p.`val` < ancestor.`val` && q.`val` < ancestor.`val` -> ancestor = ancestor.left
                p.`val` > ancestor.`val` && q.`val` > ancestor.`val` -> ancestor = ancestor.right
                else -> return ancestor
            }
        }
        return ancestor
    }
}