package leetcode.intervals;

import java.util.TreeMap;

/*
    729
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/array/729.-my-calendar-i

    use treemap
    time: O(nlogn)
    space: O(n)
 */
public class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    // intersection: pre end > current start => on the contrast, is pre end( get(low) ) <= current start
    private boolean book(int start, int end) {
        Integer low = map.lowerKey(end); //
        if (low == null || map.get(low) <= start) {
            map.put(start, end); // key, value
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar m = new MyCalendar();
        System.out.println(m.book(20, 30));
        System.out.println(m.book(15, 25));
//        System.out.println(m.book(20, 30));
    }
}
