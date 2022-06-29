class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        
        val queue = ArrayDeque<IntArray>()
        
        var freshCount = 0
        var count = 0

        // Put the position of all rotten oranges in queue
        // count the number of fresh oranges
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                when (grid[row][col]) {
                    1 -> freshCount++
                    2 -> queue.addLast(intArrayOf(row, col))
                }
            }
        }

        if (freshCount == 0) return 0

        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        while (queue.isNotEmpty()) {
            ++count

            for (i in queue.indices) {
                val point = queue.removeFirst()

                for (dir in dirs) {
                    val x = point[0] + dir[0]
                    val y = point[1] + dir[1]

                    if (!(x in grid.indices) || !(y in grid[0].indices) || grid[x][y] == 0 || grid[x][y] == 2) continue

                    grid[x][y] = 2
                    queue.addLast(intArrayOf(x, y))
                    
                    freshCount--
                }
            }
        }

        return if (freshCount == 0) count - 1 else -1
    }
}