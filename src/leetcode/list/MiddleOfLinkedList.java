package leetcode.list;

/*
    876. Middle of the Linked List
    https://leetcode.com/problems/middle-of-the-linked-list/

    用快慢指針

    一個1倍速
    一個2倍速

    回傳1倍速的
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
