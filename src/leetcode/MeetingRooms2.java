package leetcode;

import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;

/*
    https://leetcode.com/problems/meeting-rooms-ii/

    記得那個圖~~solution那個
    explain:
    https://www.jianshu.com/p/ab729e7ddac9

    Time Complexity: O(NlogN) because all we are doing is sorting the two arrays
    for start timings and end timings individually and each of them would contain N
    elements considering there are N intervals.

    Space Complexity: O(N) because we create two separate arrays of size N,
    one for recording the start times and one for the end times.
*/
public class MeetingRooms2 {


    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return 0;
        }

        // 分成 start 和 end 兩個陣列, 做排序
        // 之後一個一個比
        int start[] = new int[len];
        int end[] = new int[len];

        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int endPointer = 0;
        int rooms = 0;

        // 跑 start point 到結束
        for(int startPointer = 0; startPointer < len ; startPointer++) {

            // 當 end > start, 代表房間還在用, 要新開
            if (start[startPointer] < end[endPointer]) {
                rooms++;
            } else {
                // when start >= end, use the end room, so it wont need to open a new one
                // endPointer++ 代表用同一個房間, 時間延長了
                endPointer++;
            }
        }

        return rooms;
    }

    public static void main(String[] args) {

        int vArray[][] = {{0, 30}, {5, 10}, {15, 20}};


        System.out.print(new MeetingRooms2().minMeetingRooms(vArray));

    }
}
