package leetcode.array.java;
/*
    leetcode 435
    time:O(nlogn)
    space:O(1)
 */
import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 ||
                intervals[0] == null || intervals[0].length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1;
        int end = intervals[0][1]; // notice this,  we will skip overlaping, so we update the newest end
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1]; // update end
                count++;
            }
        }
        return intervals.length - count;
    }
}
