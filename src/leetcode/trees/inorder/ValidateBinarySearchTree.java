package leetcode.trees.inorder;

import leetcode.trees.TreeNode;

/*
    98. Validate Binary Search Tree
    https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/tree/98.-validate-binary-search-tree
    time: O(n)
    spaceL O(n)
 */
public class ValidateBinarySearchTree {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        private boolean helper(TreeNode root, long lower, long upper) {
            if (root == null) return true;
            if (root.val <= lower) return false;
            if (root.val >= upper) return false;
            return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
        }

    }

    class Solution2 {
        // use inorder, inorder must be asc order

        // cant use Integer.MIN_VALUE, test case has [Integer.MIN_VALUE],
        // so root.val <= pre will true => then return false,
        // but it only has on single node [Integer.MIN_VALUE]
        private Integer pre = null;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;

            if (!isValidBST(root.left)) return false; // run left

            if (pre != null && root.val <= pre) return false;
            pre = root.val;


            return isValidBST(root.right); // run right
        }

    }
}
