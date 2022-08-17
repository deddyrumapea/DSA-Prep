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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result
        
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val levelVals = mutableListOf<Int>()
            
            for (i in 0..(queue.size - 1)) {
                val node = queue.removeFirst()
                
                levelVals.add(node.`val`)
                
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }

            if (levelVals.isNotEmpty()) result.add(levelVals)
        }

        return result
    }
}