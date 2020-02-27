package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        //Arrays.fill(used, false);

        backtrack(result, new ArrayList<>(), used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;

                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                used[i] = true;

                backtrack(result, tempList, used, nums);

                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
