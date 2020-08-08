package leetcode.trees.preorder;

import leetcode.trees.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.right);
        int right = maxDepth(root.left);

        return Math.max(left, right) + 1;
    }

}
