package Interviews;

import java.time.Duration;
import java.time.LocalDateTime;

class Solution1 {
    public int solution(String A, String B) {
        if (A == null || B == null) return 0;

        if (A.equals(B)) return 0;
        int time[] = new int[]{0, 15 ,30, 45, 60};

        int hourA = Integer.valueOf(A.split(":")[0]);
        int minA = Integer.valueOf(A.split(":")[1]);
        int hourB = Integer.valueOf(B.split(":")[0]);
        int minB = Integer.valueOf(B.split(":")[1]);

        int startDay = 1;
        int endDay = hourA > hourB ? startDay+1 : 1;

//        System.out.println(hourA);
        System.out.println(minA);
        System.out.println(minB + "\n");

        System.out.println("h:"+hourA);
        System.out.println("h:"+hourB + "\n");

        int startMin = 0;
        int endMin = 0;
        for (int t : time) {
            if (t >= minA) {
                startMin = t;
                break;
            }
        }
        for (int i = 0; i < time.length - 1 ;i ++) {
            if (time[i] <= minB && time[i+1] >= minB) {
                endMin = time[i];
            }
        }
        System.out.println(startMin +" " + endMin + "\n");

        LocalDateTime startTime = LocalDateTime.of(2021, 1, startDay, hourA, startMin);
        LocalDateTime endTime = LocalDateTime.of(2021, 1, endDay, hourB, endMin);
        System.out.println("s: "+startTime);
        System.out.println("e:" + endTime);
        Long result = Duration.between(startTime, endTime).getSeconds()/Long.valueOf(15*60);
        System.out.println(result);
        return result.intValue();
    }

    public static void main(String[] args) {
        String A = "20:00";
        String B = "06:00";
        new Solution1().solution(A, B);
//        String A1 = "13:40";
//        String B1 = "14:02";
//        new Solution1().solution(A1, B1);
        // 13:40 ~ 14:02
    }
}
