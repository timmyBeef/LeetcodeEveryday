package leetcode.trees;

import java.util.*;

/*
https://leetcode.com/problems/range-sum-of-bst/

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree.

Space Complexity: O(H)O(H), where HH is the height of the tree.

*/
public class RangeSumOfBST {

    //iterative
    public int rangeSumBST2(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }

    // recursice
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) {
            return 0;
        }

        if(root.val > R) {
            return rangeSumBST(root.left, L ,R);

        }
        if(root.val < L) {
            return rangeSumBST(root.right, L ,R);
        }

        return root.val + rangeSumBST(root.left, L ,R) + rangeSumBST(root.right, L ,R);
    }

//               4
//              / \
//             2  5
//             /\
//            1 3
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(String.valueOf(new RangeSumOfBST().rangeSumBST2(n1, 0, 3)));

    }
}