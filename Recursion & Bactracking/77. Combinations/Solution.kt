class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val combs = mutableListOf<List<Int>>()
        val comb = mutableListOf<Int>()
        generateCombs(combs, comb, 1, n, k)
        return combs
    }

    private fun generateCombs(
            combs: MutableList<List<Int>>,
            comb: MutableList<Int>,
            start: Int,
            n: Int,
            k: Int
    ) {
        if (comb.size == k) {
            combs.add(comb.toList())
            return
        }

        for (i in start..n) {
            comb.add(element = i)
            generateCombs(combs, comb, i + 1, n, k)
            comb.remove(element = i)
        }
    }
}
