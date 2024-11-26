class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0

        val infectors = ArrayDeque<IntArray>()
        var fresh = 0

        // put the possition of all rotten oranges in infectors
        // count the number of fresh oranges
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                when (grid[row][col]) {
                    1 -> ++fresh
                    2 -> infectors.addLast(intArrayOf(row, col))
                }
            }
        }

        if (fresh == 0) return 0

        var time = 0
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1),
        )
        while (infectors.isNotEmpty()) {
            repeat (infectors.count()) {
                val infector = infectors.removeFirst()

                for (dir in dirs) {
                    val x = infector[0] + dir[0]
                    val y = infector[1] + dir[1]

                    if (x !in grid.indices || y !in grid[x].indices || grid[x][y] == 0 || grid[x][y] == 2) continue

                    grid[x][y] = 2
                    infectors.addLast(intArrayOf(x, y))
                    --fresh
                }
            }

            if (infectors.isNotEmpty()) ++time
        }

        return when (fresh == 0) {
            true -> time
            false -> -1
        }
    }
}
