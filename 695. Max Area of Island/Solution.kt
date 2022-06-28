class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    	var maxArea = 0

    	for (i in grid.indices) {
    		for (j in grid[i].indices){
    			if (grid[i][j] == 1){
    				maxArea = Math.max(maxArea, areaOfIsland(grid, i, j))
    			}
    		}
    	}

    	return maxArea
    }

    private fun areaOfIsland(grid: Array<IntArray>, i: Int, j: Int): Int {
    	if (!(i in grid.indices) || !(j in grid[0].indices) || grid[i][j] != 1) return 0
    	grid[i][j] = 0
    	return 1 + areaOfIsland(grid, i + 1, j) + areaOfIsland(grid, i - 1, j) + areaOfIsland(grid, i, j + 1) + areaOfIsland(grid, i, j - 1)
    }
}