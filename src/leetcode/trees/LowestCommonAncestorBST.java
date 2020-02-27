package leetcode.trees;

/*
同場加映...

235. Lowest Common Ancestor of a Binary Search Tree

level: easy

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/


因為 bst 有左小右大的特性 （左子樹所有節點皆小於root, 右子樹所有節點皆大於root

1. 所以pq同時比root 大時, 代表pq在右邊, 所以要往右走
2. 所以pq同時比root 小時, 代表pq在左邊, 所以要往左走
3. 其他狀況, 代表找到了, p q在左右兩側了

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

    LCS:

    判斷方式: 找到 LCS的方式 p, q 不在此 LCS 同一側

       //說明1
       if (pVal > parentVal && qVal > parentVal) {

            // 往右走～～
            return lowestCommonAncestor(root.right, p, q);

        } else if (pVal < parentVal && qVal < parentVal) { //說明2
            // 往左走～～
            return lowestCommonAncestor(root.left, p, q);

        } else {//說明3
            //找到了 We have found the split point, i.e. the LCA node.
            return root;
        }

Time Complexity: O(N),
where N is the number of nodes in the BST. In the worst case we might
be visiting all the nodes of the BST.

Space Complexity: O(N). This is because the maximum amount of
space utilized by the recursion stack would be N since the height of a
skewed BST could be N
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);

        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);

        } else { //terminator
            return root;
        }
    }
}
