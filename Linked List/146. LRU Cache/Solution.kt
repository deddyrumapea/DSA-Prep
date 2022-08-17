class LRUCache(private val capacity: Int) {

    private val keyToNode = hashMapOf<Int, Node>()
    private val left = Node(0, 0) // Least recent
    private val right = Node(0, 0) // Most recent

    init {
        left.next = right
        right.prev = left
    }

    fun get(key: Int): Int {
        val node = keyToNode[key] ?: return -1

        removeCache(node.key)
        insertCache(node.key, node.value)

        return node.value
    }

    fun put(key: Int, value: Int) {
        keyToNode[key]?.let { removeCache(it.key) }

        insertCache(key, value)
        
        if (keyToNode.size > capacity) left.next?.let { removeCache(it.key) }
    }

    private fun removeCache(key: Int) {
        val node = keyToNode[key] ?: return

        val nodePrev = node.prev
        val nodeNext = node.next

        nodePrev?.next = nodeNext
        nodeNext?.prev = nodePrev

        keyToNode.remove(key)
    }

    private fun insertCache(key: Int, value: Int) {
        val lastRecent = right.prev
        val newNode = Node(key, value)

        lastRecent?.next = newNode
        newNode.prev = lastRecent
        
        right.prev = newNode
        newNode.next = right

        keyToNode[key] = newNode
    }

    private data class Node(
        val key: Int, 
        val value: Int,
        var next: Node? = null,
        var prev: Node? = null
    )
}