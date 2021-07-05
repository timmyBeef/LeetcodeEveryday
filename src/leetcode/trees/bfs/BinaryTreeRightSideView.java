package leetcode.trees.bfs;

import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 199. Binary Tree Right Side View
 https://app.gitbook.com/@timmybeeflin/s/cracking-leetcode/tree/199.-binary-tree-right-side-view

 time: O(n)
 space: O(D) to keep the queues, where D is a tree diameter.
 Let's use the last level to estimate the queue size. This level could contain up to N/2N/2 tree nodes in the case of complete binary tree.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return res;
    }

}
