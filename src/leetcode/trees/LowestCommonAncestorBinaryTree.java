package leetcode.trees;
/*
    236. Lowest Common Ancestor of a Binary Tree

    1. 終止條件
    2. 找左子樹
    3. 找右子樹
    4. 如果在左右子樹找到pq, 代表pq一個在左一個在右, root就會是LCS
    5. 如果只有在某一邊找到, 代表pq在同一側, 所以LCS就是某一邊找到的本身結果（題目中有提到LCS可以是p或q本身）

    time complexity: O(n), space complexity: O(n)

 */
public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. terminal condition, find p,q or not find pq => null
        if (root == null || root == p || root == q) return root;


        TreeNode left = lowestCommonAncestor(root.left, p, q);//2. find left side for p, q
        TreeNode right = lowestCommonAncestor(root.right, p, q);//3. find right side for p, q

        // 4. if find p,q in left and right side, root is LCS !
        if (left != null && right != null) return root;

        // 5. if only one side find p or q (it means p,q are all in one side),
        // it's the answer because in question we allow a node to be a descendant of itself
        return left != null ? left : right;
    }
}
