package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] f = new int[n];
        List<Integer> nums = new ArrayList<>();
        f[0] = 1;


        for (int i = 1 ; i < n ; i++) {
            f[i] = i*f[i-1];
            nums.add(i);
        }
        nums.add(n);
        k--; //4

        // 1 1 2 6
        //123

        for (int i = n; i > 0; i--) {
            int idx = k/f[i-1];
            k = k % f[i-1];
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 5));
    }
}
