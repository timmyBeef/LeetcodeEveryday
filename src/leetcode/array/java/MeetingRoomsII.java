package leetcode.array.java;

import java.util.Arrays;
/*
    time: O(nLogn)
    space: O(n)
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        int len = intervals.length; //notice the length
        int start[] = new int[len];
        int end[] = new int[len];

        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int endIdx = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (start[i] < end[endIdx]) {
                res++;
            } else {
                endIdx++;
            }
        }
        return res;
    }
}
