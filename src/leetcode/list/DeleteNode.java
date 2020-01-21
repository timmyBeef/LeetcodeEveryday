package leetcode.list;
/*
    237. Delete Node in a Linked List
    https://leetcode.com/problems/delete-node-in-a-linked-list/

    這題有點蠢...

    單獨刪除某點
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if(node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
