package leetcode.array.kotlin

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    var res = mutableListOf<IntArray>()
    val len = intervals.size
    var i = 0
    while (i < len && (intervals[i][1] < newInterval[0])) {
        res.add(intervals[i++])
    }
    var newIn = newInterval.clone()
    while (i < len && (intervals[i][0] <= newInterval[1])) {
        newIn[0] = Math.min(intervals[i][0], newIn[0])
        newIn[1] = Math.max(intervals[i][1], newIn[1])
        i++
    }
    res.add(newIn)
    while (i < len) {
        res.add(intervals[i++])
    }
    return res.toTypedArray()
}