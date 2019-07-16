package leetcode;


// https://leetcode.com/problems/reverse-linked-list/solution/
// https://www.youtube.com/watch?v=O0By4Zq0OFc&feature=youtu.be
public class ReverseLinkedList {

/*    Time complexity : O(n). Assume that nn is the list's length,
      the time complexity is O(n).

    Space complexity : O(1).
*/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //https://www.youtube.com/watch?v=MRe3UsRadKw&feature=youtu.be
    public ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
