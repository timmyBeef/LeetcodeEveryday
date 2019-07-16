package leetcode.trees;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
/*
   因為此題要的是inorder traveral

   所以一定是 left node right

   所以next取值的方式:
   left 先, 所以用stack一直把 left 存起來

   到底了, 把 stack pop, 並把目前設為此node的right, 回傳值
 */
public class BSTIterator {
    Stack<TreeNode> stack =  null ;
    TreeNode current = null ;

    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left ;
        }
        TreeNode t = stack.pop() ;
        current = t.right ;
        return t.val ;
    }
//               4
//              / \
//             2  5
//                /\
//               1 3
    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        root.left = n2;
        root.right = n3;
        n3.left = n4;
        n3.right = n5;

        BSTIterator b = new BSTIterator(root);
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.next());

    }
}
