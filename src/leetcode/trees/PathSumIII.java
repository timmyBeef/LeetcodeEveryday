package leetcode.trees;

import java.util.HashMap;
import java.util.Map;

/*

    437. Path Sum III
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/tree/437.-path-sum-iii
    time: O(n)
    space: O(n)
 */
public class PathSumIII {
    // use hash map to store map(presum, count)
    // presum, if map.get(presum - target) exists, retirive the count(it's the correct path)
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, targetSum, map);
    }

    private int helper(TreeNode node, int curSum, int targetSum, Map<Integer, Integer> map) {
        if (node == null) return 0;

        curSum += node.val;

        int res = map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += helper(node.left, curSum, targetSum, map);
        res += helper(node.right, curSum, targetSum, map);
        map.put(curSum, map.get(curSum) - 1); // backtracking
        return res;
    }

}
