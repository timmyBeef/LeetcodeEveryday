package leetcode.list;


//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    /*
    Time complexity : O(n+m)

    Because each recursive call increments the pointer to l1 or l2 by one
    (approaching the dangling null at the end of each list),
    there will be exactly one call to mergeTwoLists per element in each list.
    Therefore, the time complexity is linear in the combined size of the lists.

    Space complexity : O(n+m)

    The first call to mergeTwoLists does not return until the ends of both l1 and l2
    have been reached, so n + m stack frames consume O(n+m) space.
 */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // use prev to link two list
    // 做一個頭  prehead (-1)
    // 然後用 prev 去串 l1 l2
    // l2.val >= l1.val  prev 連 l1, l1移到下一個位置
    // 反之 prev 連 l2, l2移到下一個位置
    // 其中一個 已經走完的話(next == null), 結束
    // 最後prev 串剩下的 所以判斷 l1 若 null, 串 l2, 反之...
    // 回傳 prehead.next 就是頭

   /*
    Time complexity : O(n+m)

    Because exactly one of l1 and l2 is incremented on each loop iteration,
    the while loop runs for a number of iterations equal to the sum of the
    lengths of the two lists. All other work is constant, so the overall
    complexity is linear.

    Space complexity : O(1)

    The iterative approach only allocates a few pointers, so it has a constant
    overall memory footprint.
    */
    public ListNode mergeTwoListsByIter(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = (l1 == null) ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        //Input: 1->2->4, 1->3->4
        //Output: 1->1->2->3->4->4
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n4.next = n5;
        n5.next = n6;

//        ListNode rs = new MergeTwoSortedLists().mergeTwoLists(n1, n4);
//        while (rs.next != null) {
//            System.out.println(rs.val);
//            rs = rs.next;
//        }
//        System.out.println(rs.val);

        ListNode rs2 = new MergeTwoSortedLists().mergeTwoListsByIter(n1, n4);
        while (rs2.next != null) {
            System.out.println(rs2.val);
            rs2 = rs2.next;
        }
        System.out.println(rs2.val);

    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}