package leetcode;


// https://leetcode.com/problems/closest-binary-search-tree-value/

// 遞迴就是要一值更新值, 最後得到結果

/*
Time Complexity: O(N). We visit every node once.

Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
*/
public class ClosetBSTValue {


    public int closestValue(TreeNode root, double target) {
        return findCloset(root, target, root.val);
    }

    public int findCloset(TreeNode node, double target, int value) {
        if(node == null) {
            return value;
        }

        // 如果新的 value 差距還比較大, 那新值就是 node.val
        if(Math.abs(node.val - target) < Math.abs(value - target)) { //!!!
            value = node.val; //!!
        }


        // target 比較大, 所以往右找
        if (node.val < target) {
            value = findCloset(node.right, target, value); //!!
        } else  if(node.val > target) { // target 比較小, 所以往左找
            value = findCloset(node.left, target, value); //!!
        }

        return value;
    }

//               4
//              / \
//             2  5
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

