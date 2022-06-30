class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val color = image[sr][sc]
    	if (color != newColor) dfs(image, sr, sc, color, newColor)
        return image
    }
    
    fun dfs(image: Array<IntArray>, sr: Int, sc: Int, color: Int, newColor: Int){
        if (image[sr][sc] == color){
            image[sr][sc] = newColor
            if (sr >= 1) dfs(image, sr - 1, sc, color, newColor)
            if (sc >= 1) dfs(image, sr, sc - 1, color, newColor)
            if((sr + 1) < image.size) dfs(image, sr + 1, sc, color, newColor)
            if((sc + 1) < image[0].size) dfs(image, sr, sc + 1, color, newColor)
        }
    }

    fun floodFill2(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    	if (image[sr][sc] == newColor) return image
    	fill(image, sr, sc, image[sr][sc], newColor)
    	return image
    }

    private fun fill(image: Array<IntArray>, sr: Int, sc: Int, color: Int, newColor: Int) {
    	if (!(sr in image.indices) || !(sc in image[0].indices) || image[sr][sc] != color) return

    	image[sr][sc] = newColor
    	fill(image, sr + 1, sc, color, newColor)
    	fill(image, sr - 1, sc, color, newColor)
    	fill(image, sr, sc + 1, color, newColor)
    	fill(image, sr, sc - 1, color, newColor)
    }
}