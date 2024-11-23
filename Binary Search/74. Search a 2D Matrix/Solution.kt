// Solved in 15 minutes
// Time complexity: O(log n)
// Space complexity: O(1)
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var top = 0
        var bottom = matrix.lastIndex

        while (top <= bottom) {
            val vMid = top + (bottom - top) / 2
            val row = matrix[vMid]

            when {
                target in row.first()..row.last() -> {
                    var left = 0
                    var right = row.lastIndex

                    while (left <= right) {
                        val hMid = left + (right - left) / 2
                        
                        when {
                            row[hMid] == target -> return true
                            row[hMid] < target -> left = hMid + 1
                            else -> right = hMid -1
                        }
                    }

                    return false
                }

                row.last() < target -> top = vMid + 1

                row.first() > target -> bottom = vMid - 1
            }
        }

        return false
    }
}

// Solved in 6 minutes
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var flat = intArrayOf()
        for (row in matrix) flat = intArrayOf(*flat, *row)
        
        var left = 0
        var right = flat.lastIndex
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (flat[mid] == target) return true
            if (flat[mid] < target) left = mid + 1
            else right = mid - 1
        }
        
        return false
    }
}
