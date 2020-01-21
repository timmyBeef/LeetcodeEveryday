package leetcode.list;
/*
    203. Remove Linked List Elements

    https://leetcode.com/problems/remove-linked-list-elements/

    用dummy node, 模擬出一個假的pre

    這樣就可以正常做了,

    注意prev要跟著動
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while(current != null) {
            if(current.val == val) {
                prev.next = current.next;
            } else {
                prev = prev.next;
            }

            current = current.next;
        }
        return dummy.next;
    }
}
