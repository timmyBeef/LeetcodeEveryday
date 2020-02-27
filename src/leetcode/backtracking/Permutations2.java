package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;

                used[i] = true;
                tempList.add(nums[i]);

                backtrack(result, tempList, used, nums);

                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
