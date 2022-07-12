/**
 * Definition of Interval:
 * class Interval {
 *     var start: Int = 0
 *     var end: Int = 0
 *     constructor(start: Int, end: Int) {
 *         this.start = start
 *         this.end = end
 *     }
 * }
 */

class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    fun canAttendMeetings(intervals: List<Interval?>): Boolean {
        var lastEnd: Int? = null
        val intervals = intervals
            .mapNotNull{ it }
            .sortedBy{ it.start }

        for (interval in intervals) {
            if (lastEnd != null && interval.start < lastEnd) return false
            lastEnd = interval.end
        }

        return true
    }
}