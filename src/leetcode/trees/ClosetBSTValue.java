package leetcode.trees;


// https://leetcode.com/problems/closest-binary-search-tree-value/



/*

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

use binary search

closest 之前最近的結果

val now node's val

return closest;

Time complexity : O(H) since here one goes from root down to a leaf.

Space complexity : O(1).
*/
public class ClosetBSTValue {


    public int closestValue(TreeNode root, double target) {
        int val;
        int closest = root.val;

        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root =  target < root.val ? root.left : root.right;
        }
        return closest;
    }


//               4
//              / \
//             2  5     4->2->3  Math.abs(3 - 3.7) < Math.abs(4 - 3.7) ? val : closest  => closest = 4
//             /\
//            1 3
    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(4);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(5);
//        TreeNode n4 = new TreeNode(1);
//        TreeNode n5 = new TreeNode(3);
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//
        double target = 3.714286;
//
//        System.out.println(String.valueOf(new ClosetBSTValue().closestValue(n1, target)));


        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(2);
        n6.left = null;
        n6.right = n7;
        System.out.println(String.valueOf(new ClosetBSTValue().closestValue(n6, target)));

    }
}

