package leetcode.trees.preorder;

import leetcode.trees.TreeNode;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return cal(root, 0);
    }

    private int cal(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int currentSum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        return cal(root.left, currentSum) + cal(root.right, currentSum);

    }

}
