package leetcode.trees.preorder;

import leetcode.trees.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricSubtree(root.left, root.right);
    }

    private boolean isSymmetricSubtree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetricSubtree(left.left, right.right) && isSymmetricSubtree(left.right, right.left);
    }

}
