class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var a = nums1
        var b = nums2

        if (b.size < a.size) {
            a = nums2
            b = nums1
        }

        val totalSize = nums1.size + nums2.size
        val halfSize = (totalSize + 1) / 2

        var aLeft = 0
        var aRight = a.size
        while (aLeft <= aRight) {
            val aMid = aLeft + (aRight - aLeft) / 2
            val bMid = halfSize - aMid

            val aSmallMax = if (aMid > 0) a[aMid - 1] else Int.MIN_VALUE
            val aBigMin = if (aMid < a.size) a[aMid] else Int.MAX_VALUE
            val bSmallMax = if (bMid > 0) b[bMid - 1] else Int.MIN_VALUE
            val bBigMin = if (bMid < b.size) b[bMid] else Int.MAX_VALUE

            when {
                aSmallMax <= bBigMin && bSmallMax <= aBigMin -> {
                    return when (totalSize % 2 == 0) {
                        true -> (Math.max(aSmallMax, bSmallMax) + Math.min(aBigMin, bBigMin)).toDouble() / 2
                        false -> Math.max(aSmallMax, bSmallMax).toDouble()
                    }
                }

                aSmallMax > bBigMin -> aRight = aMid - 1
                
                else -> aLeft = aMid + 1
            }
        }

        return -1.0
    }
}