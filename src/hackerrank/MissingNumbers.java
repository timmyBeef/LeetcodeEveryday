package hackerrank;

import java.util.Arrays;
import java.util.TreeMap;

/*
    https://studyalgorithms.com/array/hackerrank-missing-numbers/
    brr is longer

    time: O(n)
    space: O(n)
 */
public class MissingNumbers {
    static int[] missingNumbers(int[] arr, int[] brr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int b : brr) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        // 1, 2, 3, 4
        // 1, 2 ,3 , 3, 4
        for (int a : arr) {
            if (map.containsKey(a)) {
                int count = map.get(a) - 1;
                if (count == 0) {
                    System.out.println("count==0");
                    map.remove(a);
                } else {
                    System.out.println("ma put");
                    map.put(a, count);
                }
            }
        }
        int rs[] = new int[map.size()];
        System.out.println(map.size());

        int i = 0;
        for (int k : map.keySet()) {
            rs[i++] = k;
        }
        return rs;
    }

    public static void main(String[] args) {
        int rs[] = MissingNumbers.missingNumbers(new int[]{1,2,3,4}, new int[]{1,2,3,4,5});
        Arrays.stream(rs).forEach(System.out::println);
    }
}
