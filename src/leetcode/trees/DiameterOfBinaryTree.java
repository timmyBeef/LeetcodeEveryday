package leetcode.trees;


// https://leetcode.com/problems/diameter-of-binary-tree/

// use DFS

//The diameter of a binary tree
//is the length of the longest path between any two nodes in a tree.

//Diameter is actually max(node.leftDepth + node.rightDepth)
//for node can be any one in the tree.

//So we build a helper method getDepth to get depth of a subtree
//recursively and update diameter all the way.

// 注意結果是看 max, 要得是 max(node.leftDepth + node.rightDepth)

/*
Time Complexity: O(N). We visit every node once.

Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
*/
public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        max = Math.max(max, L + R);
        return Math.max(L, R) + 1;
    }

    // m(1) = m(2)+m(3) = Math.max(2, 1) + 1 = 3;  max = Math.max(2, 2 + 1) = 3;
    // m2 = m(4) + m(5) = 2
    // m3 = null(0) + 1;
    //m(4) = null(0) + 1;
    //m(5) = null(0) + 1;

//               1
//              / \
//             2  3
//             /\
//            4 5
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(String.valueOf(new DiameterOfBinaryTree().diameterOfBinaryTree(n1)));


    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

