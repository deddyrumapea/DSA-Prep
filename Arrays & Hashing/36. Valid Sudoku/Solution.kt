// Solved in ~30 minutes
// Time complexity: O(9^2) = O(1)
// Space complexity: O(3 * 3 + 9 + 9) = O(1)
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val boxChars = Array(3) { Array(3) { mutableSetOf<Char>() }  }
        val rowChars = mutableSetOf<Char>()
        
        for (i in 0..8) {
            val colChars = mutableSetOf<Char>()
            
            for (j in 0..8) {
                if (board[i][j] != '.' && !boxChars[i / 3][j / 3].add(board[i][j])) return false
                if (board[i][j] != '.' && !colChars.add(board[i][j])) return false
                if (board[j][i] != '.' && !rowChars.add(board[j][i])) return false
            }
            
            rowChars.clear()
        }
        
        return true
    }
}