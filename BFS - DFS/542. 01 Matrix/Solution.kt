class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val queue = ArrayDeque<Pair<Int, Int>>()
        for (row in mat.indices) {
            for (col in mat[row].indices) {
                if (mat[row][col] == 0) queue.addLast(Pair(row, col))
                else mat[row][col] = Int.MAX_VALUE
            }
        }

        val dirs = intArrayOf(0, -1, 0, 1, 0)
        while (queue.isNotEmpty()) {
            for(i in queue.indices) {
                val (row, col) = queue.removeFirst()

                for (d in 0 until 4) {
                    val nextRow = row + dirs[d]
                    val nextCol = col + dirs[d + 1]

                    if (!(nextRow in mat.indices) || !(nextCol in mat[0].indices) || mat[nextRow][nextCol] != Int.MAX_VALUE) continue

                    mat[nextRow][nextCol] = 1 + mat[row][col]
                    queue.addLast(Pair(nextRow, nextCol))
                }
            }
        }

        return mat
    }
}