// Solved in ~30 minutes
// Time complexity: O(9^2) = O(1)
// Space complexity: O(3 * 3 + 9 + 9) = O(1)
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val boxSet = Array(3) { Array(3) { mutableSetOf<Char>() } }
        
        for (i in 0..8) {
            val rowSet = mutableSetOf<Char>()
            val colSet = mutableSetOf<Char>()
            
            for (j in 0..8) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) return false
                if (board[j][i] != '.' && !colSet.add(board[j][i])) return false
                if (board[i][j] != '.' && !boxSet[i / 3][j / 3].add(board[i][j])) return false
            }
        }
        
        return true
    }
}