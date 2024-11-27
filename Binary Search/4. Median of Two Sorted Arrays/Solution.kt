class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        val half = (total + 1) / 2

        var a = nums1
        var b = nums2
        
        if (b.size < a.size) {
            a = nums2
            b = nums1
        }

        var l = 0
        var r = a.size

        while (l <= r) {
            val i = l + (r - l) / 2
            val j = half - i

            val aLeft = if (i > 0) a[i - 1] else Int.MIN_VALUE
            val aRight = if (i < a.size) a[i] else Int.MAX_VALUE
            val bLeft = if (j > 0) b[j - 1] else Int.MIN_VALUE
            val bRight = if (j < b.size) b[j] else Int.MAX_VALUE

            when {
                aLeft <= bRight && bLeft <= aRight -> {
                    return when (total % 2 == 0) {
                        true -> {
                            (Math.max(aLeft.toDouble(), bLeft.toDouble()) +
                                Math.min(aRight.toDouble(), bRight.toDouble())) / 2.0
                        }
                        false -> Math.max(aLeft.toDouble(), bLeft.toDouble())
                    }
                }

                aLeft > bRight -> r = i - 1

                else -> l = i + 1
            }
        }

        return -1.0
    }
}