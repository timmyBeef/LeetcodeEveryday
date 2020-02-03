package hackerrank;

import java.util.HashMap;
import java.util.Map;

/*

    https://www.hackerrank.com/challenges/icecream-parlor/problem

    it's two sum
 */
public class IceCreamParlor {
    static int[] icecreamParlor(int m, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length;i++) {
            int value = arr[i];

            if(map.containsKey(m - value)) {
                int index = map.get(m - value);
                return new int[]{index+1, i+1};
            }
            map.put(value, i);
        }
        return new int[]{};
    }
}
