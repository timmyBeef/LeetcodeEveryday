package leetcode.list;

import java.util.HashSet;

/*
83. Remove Duplicates from Sorted List

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

 */
public class DeleteDuplicates {

    public ListNode deleteDuplicatesByHashSet(ListNode head) {
        //用額外空間, use external space


        HashSet<Integer> hashSet = new HashSet<>();

        ListNode current = head;

        ListNode previous = null; //需要記錄前一個節點, 方便之後skip重複的 做連接

        while(current != null) {
            if(!hashSet.contains(current.val)) {
                hashSet.add(current.val);
                previous = current; //記下來不重複的位置
            } else {
                //遇到重複的時候
                //把不重複的和下一個接起來（skip重複的）
                // 1->2->2
                //    do skip
                // 1   (-> 2) -> 2
                previous.next = current.next;
            }
            current = current.next;
        }
        return head;

    }

    public ListNode deleteDuplicates(ListNode head) {
        // don't use external space

        //no node it will return null, 因為沒有用while(current != null) (通常的做法
        if (head == null) return null;

        ListNode current = head; //通常都會用一個變數來指到開頭

        while (current.next != null) { //notice, check next first
            if (current.val == current.next.val) {
                current.next = current.next.next; //SKIP duplicate
            } else {
                current = current.next; // go next
            }
        }

        return head;
    }

    public static void main(String[] args) {
        //Input: 1->2->2->3->3
        //Output: 1->2->3
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        ListNode rs = new DeleteDuplicates().deleteDuplicates(n1);
        ListNode.print(rs);
    }
}
