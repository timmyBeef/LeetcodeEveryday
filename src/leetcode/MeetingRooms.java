package leetcode;

// https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;
import java.util.Comparator;

// SORT first(use start to sort), then if end > start: false
// O(nlogn)
// O(1)
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
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
