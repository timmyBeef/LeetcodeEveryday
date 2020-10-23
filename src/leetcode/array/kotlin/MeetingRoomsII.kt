package leetcode.array.kotlin

import java.util.*

// do sort
// si < e, rooms++
// else e+
fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val len = intervals.size
    var start = IntArray(len)
    var end = IntArray(len)

    for (i in 0 until len) {
        start[i] = intervals[i][0]
        end[i] = intervals[i][1]
    }
    Arrays.sort(start)
    Arrays.sort(end)
    var res = 0;
    var endIdx = 0;
    start.forEach { s ->
        if (s < end[endIdx]) {
            res++;
        } else {
            endIdx++
        }
    }
    return res;
}