class TimeMap() {
    
    private val map = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (map[key] != null) map[key]?.add(Pair(value, timestamp))
        else map[key] = mutableListOf(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val pairs = map[key] ?: return ""
        
        var left = 0
        var right = pairs.lastIndex
        
        var result: Pair<String, Int>? = null
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (pairs[mid].second == timestamp) return pairs[mid].first
            
            if (pairs[mid].second < timestamp) {
                if (result == null || pairs[mid].second > result.second) {
                    result = pairs[mid]
                }
                
                left = mid + 1
            } else {
                right = mid - 1
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

// Time Limit Exceeded
class TimeMap() {
    
    private val items = mutableListOf<TimeMapItem>()

    fun set(key: String, value: String, timestamp: Int) {
        items.add(TimeMapItem(key, value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val filtered = items
            .filter { it.key == key && it.timestamp <= timestamp }
            .sortedByDescending { it.timestamp }
            
        return if (filtered.isNotEmpty()) filtered.first().value else ""
    }
    
    
    private data class TimeMapItem(
        val key: String,
        val value: String,
        val timestamp: Int
    )

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */