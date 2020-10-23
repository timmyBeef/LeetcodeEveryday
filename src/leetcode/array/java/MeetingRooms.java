package leetcode.array.java;

import java.util.Arrays;

/*
    Given an array of meeting time intervals consisting of
    start and end times [[s1,e1],[s2,e2],...] (si < ei),
    determine if a person could attend all meetings.
    For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return false.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
/*
    time: O(nlogn)
    space: O(1)
 */
public class MeetingRooms {
    public static boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interval intervals[] = new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        if (canAttendMeetings(intervals) == false) System.out.println("pass");


        Interval intervals2[] = new Interval[]{new Interval(0, 1), new Interval(5, 10), new Interval(15, 20)};
        if (canAttendMeetings(intervals2) == true) System.out.println("pass");

    }
}

