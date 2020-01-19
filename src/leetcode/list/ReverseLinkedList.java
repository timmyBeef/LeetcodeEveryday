package leetcode.list;


// https://leetcode.com/problems/reverse-linked-list/solution/
// https://www.youtube.com/watch?v=O0By4Zq0OFc&feature=youtu.be
public class ReverseLinkedList {

/*    Time complexity : O(n). Assume that n is the list's length,
      the time complexity is O(n).

    Space complexity : O(1).

    1->2->3->4->5


    curr->prev
    1->pre=1

    把 2 先暫存, 下次回圈 就能接上 上次的頭

    2->pre=1



    <-node<-cur

            prev
    cur->   curr -> prev
*/
    public ListNode reverseList(ListNode node) {
        ListNode head = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = head;
            head = curr;
            curr = nextTemp;
        }
        return head; //prev 最後會變 head
    }

    public ListNode reverseListAndClone(ListNode node) {
        ListNode head = null;
        while (node != null) {
            ListNode curr = new ListNode(node.val);
            curr.next = head;
            head = curr;
            node = node.next;
        }
        return head; //prev 最後會變 head
    }

    // a b c d

    /*
        think about the origin link list : 1->2->3->4->5.Now assume
        that the last node has been reversed.Just like this:

1->2->3->4<-5.And this time you are at the node 3 , you want to change 3->4 to 3<-4 ,
means let 3->next->next = 3.(3->next is 4 and 4->next = 3 is to reverse it)

ex:
1->2

head.next => 2 => to recusion
head.next == null return 2
p =2

1.next.next = 1     =>     2.next = 1
2->1
head.next = null
2->1->null
return 2

     */
    public ListNode reverseListByRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        //Input: 1->2->3->4->5
        //Output: 5->4->3->2->1
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        ListNode rs = new ReverseLinkedList().reverseListAndClone(n1);
        ListNode.print(rs);
    }
}

