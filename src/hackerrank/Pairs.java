package hackerrank;

import java.util.HashSet;
import java.util.Set;

/*
http://localhost:4000/2020/01/22/hackerrank-java-pair/
 */
public class Pairs {
    static int pairs1(int k, int[] arr) {
        int count = 0;
        for(int a = 0; a < arr.length ; a++) {
            for(int b = a; b < arr.length; b++) {
                if(Math.abs(arr[a]-arr[b]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    static int pairs2(int k, int[] arr) {
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> aPlusKSet = new HashSet<>();
        for(int a : arr) {
            aSet.add(a);
        }
        for(int a : arr) {
            aPlusKSet.add(a+k);
        }
        int count = 0;
        for(int a : aSet) {
            if(aPlusKSet.contains(a)) {
                count++;
            }
        }
        return count;
    }

    static int pairs3(int k, int[] arr) {
        Set<Integer> aSet = new HashSet<>();
        for(int a : arr) {
            aSet.add(a);
        }

        return (int)aSet.stream()
                .filter(b -> aSet.contains(b - k))
                .count();

    }
}
