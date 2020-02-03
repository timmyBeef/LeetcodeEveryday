package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://www.hackerrank.com/challenges/cut-the-sticks/problem

 */
public class CutTheSticks {
    static int[] cutTheSticks(int[] arr) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(arr);

        int length = arr.length;
        result.add(length);

        int min = arr[0];
        for(int i = 0; i < length;i++) {
            if(arr[i] > min) {
                min = arr[i];
                result.add(length - i);
            }
        }

        int i = 0;
        int ans[] = new int[result.size()];
        for(int r:result) {
            ans[i++] = r;
        }
        return ans;
    }
}
