package leetcode.trees;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
/*
    next() and hasNext() should run in average O(1) time and uses O(h) memory,
    where h is the height of the tree.
You may assume that next() call will always be valid, that is,
there will be at least a next smallest number in the BST when next() is called.

   因為此題要的是inorder traveral

   所以一定是 left node right

   所以next取值的方式:
   left 先, 所以用stack一直把 left 存起來

   到底了, 把 stack pop, 並把 current 設為此node的right(下次進來若右邊有就會往右邊跑)

   , 回傳值

   hasNext O(1)
   next O(N), average O(1) time

   next involves two major operations.
   One is where we pop an element from the stack which becomes
   the next smallest element to return. This is a O(1) operation.
   However, we then make a call to our helper function _inorder_left
   which iterates over a bunch of nodes.
   This is clearly a linear time operation
   i.e. O(N) in the worst case. This is true.

   Space complexity: The space complexity is O(h) which is occupied
   by our custom stack for simulating the inorder traversal.
   Again, we satisfy the space requirements as well
   as specified in the problem statement.
 */
public class BSTIterator {
    Stack<TreeNode> stack =  null ;
    TreeNode current = null ;

    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }

    /* whether we have a next smallest number */
    public boolean hasNext() {

        return !stack.isEmpty() || current != null;
    }

    /** the next smallest number */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left ;
        } //stack all left
        TreeNode t = stack.pop() ; // pop stack
        current = t.right ; // current point to right, for next operation, if null, do pop
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
        System.out.println(b.next()); //2
        System.out.println(b.next()); //4
        System.out.println(b.next()); //1
        System.out.println(b.next()); //5
        System.out.println(b.next()); //3

    }
}
