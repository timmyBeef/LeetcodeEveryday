package leetcode.trees.preorder;

import leetcode.trees.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }
    private boolean helper(TreeNode root, int total, int givenSum) {
        if (root == null) {
            return false;
        }
        total += root.val;
        if (root.left == null && root.right == null && total == givenSum) {
            return true;
        }
        return helper(root.left, total, givenSum) || helper(root.right, total, givenSum);

    }

    // better version
    public boolean hasPathSumBetter(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (root.val == sum);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
