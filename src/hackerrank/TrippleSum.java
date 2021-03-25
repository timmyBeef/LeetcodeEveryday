package hackerrank;

import java.util.Arrays;

public class TrippleSum {
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        int[] al = getSortedSet(a);
        int[] bl = getSortedSet(b);
        int[] cl = getSortedSet(c);

        // a, c <= b
        long rs = 0l;
        for (int bn : bl) {
            int aCount = getCount(al, bn);
            int cCount = getCount(cl, bn);
            rs += (long)aCount*cCount;
        }
        return rs;
    }

    // this one is O(n)
    // private static long getCount(Integer arr[], Integer bn) {
    //     long count = 0l;
    //     for (Integer num : arr) {
    //         if (num <= bn) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // find number <= b,
    // use bs, O(nlogn)
    // because bs return index, get count is index + 1
    static int getCount(int[] distinctA, int key) {
        int left = 0;
        int right = distinctA.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (distinctA[mid] <= key) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index + 1;
    }

    private static int[] getSortedSet(int a[]) {
        return Arrays.stream(a).distinct().sorted().toArray();

    }

    public static void main(String[] args) {
        System.out.println(TrippleSum.triplets(new int[]{3, 5, 7}, new int[]{3, 6}, new int[]{4, 6, 9}));
    }
}
