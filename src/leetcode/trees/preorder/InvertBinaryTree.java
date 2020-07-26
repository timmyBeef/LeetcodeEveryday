package leetcode.trees.preorder;

import leetcode.trees.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { //termainator
            return root;
        }
        // like swap - process
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left); // drill dwon
        invertTree(root.right); // drill dwon
        return root;
    }

    // short version
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(temp);
        return root;
    }
}
