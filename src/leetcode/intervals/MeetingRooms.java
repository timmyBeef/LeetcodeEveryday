package leetcode.intervals;

// https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;
import java.util.Comparator;

// SORT first(use start to sort), then if end > start: false
/*
Time complexity : O(nlogn).
The time complexity is dominated by sorting. Once the array has been sorted,
only O(n) time is taken to go through the array and determine if there is any overlap.
每回合的合併需要花：O(n)
總共需要回合數：O(log n) => nlogn


Space complexity : O(1). Since no additional space is allocated.
 */
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        // Arrays.sort(intervals, (o1,o2) -> o1[0] - o2[0]);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < intervals.length-1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int vArray[][] = {{0,30},{5,10},{15,20}};


        System.out.print(new MeetingRooms().canAttendMeetings(vArray));

    }
}
