package leetcode.trees.basic;

import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNums = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNums; i++) {

                TreeNode node = queue.poll();
                subList.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(subList);
        }
        return result;
    }
}
