package leetcode.trees;

/*
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

    LCS:

    判斷方式: 找到 LCS的放式 p, q 不在此 LCS 同一側

       if (pVal > parentVal && qVal > parentVal) {

            // 往右走～～
            return lowestCommonAncestor(root.right, p, q);

        } else if (pVal < parentVal && qVal < parentVal) {
            // 往左走～～
            return lowestCommonAncestor(root.left, p, q);

        } else {
            //找到了 We have found the split point, i.e. the LCA node.
            return root;
        }

Time Complexity: O(N),
where N is the number of nodes in the BST. In the worst case we might
be visiting all the nodes of the BST.

Space Complexity: O(N). This is because the maximum amount of
space utilized by the recursion stack would be N since the height of a
skewed BST could be NN
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor(root.right, p, q);

        } else if(pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left, p, q);

        } else {
            return root;
        }
    }
}
