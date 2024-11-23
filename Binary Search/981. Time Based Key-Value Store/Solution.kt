class TimeMap() {
    
    private val map = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        when (val pairs = map[key]) {
            null -> map[key] = mutableListOf(Pair(value, timestamp))
            else -> pairs.add(Pair(value, timestamp))
        }
    }

    fun get(key: String, timestamp: Int): String {
        val pairs = map[key] ?: return ""

        var left = 0
        var right = pairs.lastIndex

        var result: Pair<String, Int>? = null

        while (left <= right) {
            val mid = left + (right - left) / 2
            val (midValue, midTimestamp) = pairs[mid]

            when {
                midTimestamp == timestamp -> return midValue
                
                midTimestamp < timestamp -> {
                    if (result == null || midTimestamp > result.second) {
                        result = pairs[mid]
                    }

                    left = mid + 1
                }
                
                else -> {
                    right = mid - 1
                }    
            }
        }

        return result?.first ?: ""
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */
