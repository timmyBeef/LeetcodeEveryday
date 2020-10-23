package leetcode.array.kotlin

import java.util.*
import kotlin.test.assertEquals

data class Interval(var start: Int = 0, var end: Int = 0)

fun canAttendMeetings(intervals: Array<Interval>): Boolean {
    Arrays.sort(intervals) { x, y -> x.start - y.start }

    for (i in 1 until intervals.size) {
        if (intervals[i - 1].end > intervals[i].start) {
            return false
        }
    }
    return true
}

/*
    Given [[0, 30],[5, 10],[15, 20]],
    return false.
 */
fun main() {
    var intervals = arrayOf(Interval(0, 30), Interval(5, 10), Interval(15, 20))
    assertEquals(false, canAttendMeetings(intervals))

    var intervals2 = arrayOf(Interval(0, 1), Interval(5, 10), Interval(15, 20))
    assertEquals(true, canAttendMeetings(intervals2))
}