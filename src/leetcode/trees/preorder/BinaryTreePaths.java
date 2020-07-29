package leetcode.trees.preorder;

import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        helper(root, res, "");
        return res;
    }

    private void helper(TreeNode root, List<String> res, String path) {
        if (root == null) { // terminator 1
            return;
        }
        if (root.left == null && root.right == null) { // terminator 2
            res.add(path + root.val);
        }
        helper(root.left, res, path + root.val + "->"); // drill down
        helper(root.right, res, path + root.val + "->");

    }

    // using StringBuilder is faster
    public List<String> binaryTreePathsStringBuilder(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, new StringBuilder());
        return res;
    }

    private void helper(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) { // terminator 1
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) { // terminator 2
            res.add(sb.toString());
        }
        sb.append("->");
        String sbTemp = sb.toString(); // if use sb, it should create another sb object to run

        helper(root.left, res, sb);  // drill down
        helper(root.right, res, new StringBuilder(sbTemp)); // drill down
    }
}
