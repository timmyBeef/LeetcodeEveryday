package leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoGroupArray {

    public void cal(Integer arr[]) {
        int sum = 0;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            sum += arr[i];
            System.out.println(arr[i]);
        }
        System.out.println("sum:"+sum);
        // 34 28 28 20 15
        // 125  62 >   125-62 = 63  a[34, 28
        int aSum = 0;
        for (int i = 0; i < 5; i++) {
            aSum += arr[i];
            System.out.println("aSum:" + aSum + ", sum - aSum:" + (sum - aSum));
            if (aSum > (sum - aSum)) {
                a.add(arr[i]);
                break;
            } else {
                a.add(arr[i]);
                System.out.println("a:" + a.toString());
            }
        }
            System.out.println(a.toString());

    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = (int)(Math.random() * 49 + 1);
        }
        new TwoGroupArray().cal(arr);
    }
}

