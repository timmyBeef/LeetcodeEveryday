package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

time complexity: O(C(n, k)), space complexity: O(k)

 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k); //start from 1
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (k == 0) { // terminal condition: when k == 0
            result.add(new ArrayList<>(tempList));
            return;
        } else {
            for (int i = start; i <= n - k + 1; i++) { // why n - k +1, it's a precise way to indicate the range, because when jump to next recursion level, k is changed, we should recaculate to "n - k + 1", not always to use n
                tempList.add(i);
                backtrack(result, tempList, i + 1, n, k - 1);
                tempList.remove(tempList.size() - 1); // backtrack
            }
        }
    }
}
