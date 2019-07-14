package leetcode.trees;

/*
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

keypoint: 做一個 dummy node 來 連接 頭尾

step 1, 跑 dfs inorder
step 2, use dummy to 連接 頭尾
                                                  |prev  |
|dummy|   <->   |->    -| node | <-> | node | <-> | node | <-  ---
|prev |         |      \                                    |    |
                |      \                                    |     |
                |      \  dummy.right.left = prev;         |     |
                |       \----------------------------------|     |
                |                                                |
                |                                                |
                |                     prev.right = dummy.right;  |
                -------------------------------------------------|

                最後 return dummy.right;

Time complexity : O(N) since each node is processed exactly once.

Space complexity : O(N). We have to keep a recursion stack of the size of the tree height,
        which is O(logN) for the best case of completely balanced tree and O(N) for the
        worst case of completely unbalanced tree.
*/
public class ConvertBSTtoSortedDoublyLinkedList {
    Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(Node cur) {
        if (cur == null) return;//!! 無回傳
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right); //!! 無回傳
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};