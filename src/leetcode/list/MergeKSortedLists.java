package leetcode.list;

public class MergeKSortedLists {

    // 相當 trick 的一題
    // mergeTwoList 用原本的
    // 因為 兩兩merge,
    // Thus, we'll traverse almost N nodes per pairing and merging,
    // and repeat this procedure about logk times.
    // 走了n節點, 然後因為是倆倆合併, 所以時間需要 logk times. => O(Nlogk)

/*  Time complexity : O(Nlogk) where k is the number of linked lists.
    Space complexity : O(1)  use mergeTwoListsByIter

    We can merge two sorted linked lists in O(1)O(1) space.
    */


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        // 看 solution 圖解
        // 倆倆合併
        // 第一round merge 0跟1, 2跟3, 4跟5, 所以利用 interval*2 來遞增i, 控制跑幾次迴圈
        // list[i] = mergeTwoLists(list[i], list[i+interval]) 來 merge
        // 迴圈完, 加大 interval :  interval*=2

        //重覆到 while(interval < lists.length) 結束

        // 0, 0+1, i+=2, [0][1]
        //                2  3
        //                4  5

        //interval*=2;
        // 0, 2,   2, 4


        // 最後回傳 lists[0]
        int interval = 1;
        while(interval < lists.length){
            for (int i = 0; i + interval< lists.length; i += interval*2) { //!!
                lists[i] = new MergeTwoSortedLists().mergeTwoListsByIter(lists[i],lists[i+interval]); //!!
            }
            interval*=2;
        }

        return lists[0];
    }

    public static void main(String[] args) {
/*
        Input:
        [
        1->4->5,
        1->3->4,
        2->6
        ]

        Output: 1->1->2->3->4->4->5->6
        */
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);

        n4.next = n5;
        n5.next = n6;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(6);

        n7.next = n8;

        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(4);
        ListNode x3 = new ListNode(5);

        x1.next = x2;
        x2.next = x3;

        ListNode x4 = new ListNode(1);
        ListNode x5 = new ListNode(3);
        ListNode x6 = new ListNode(4);

        x4.next = x5;
        x5.next = x6;

        ListNode x7 = new ListNode(2);
        ListNode x8 = new ListNode(6);

        x7.next = x8;

        ListNode[] n = {n1, n4, n7, x1, x4, x7};

        ListNode rs2 = new MergeKSortedLists().mergeKLists(n);

        while (rs2.next != null) {
            System.out.println(rs2.val);
            rs2 = rs2.next;
        }
        System.out.println(rs2.val);

    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     public static void print(ListNode head) {
         StringBuilder result = new StringBuilder();
         ListNode current = head;
         while (current.next != null) {
             result.append(current.val).append("->");
             current = current.next;
         }
         result.append(current.val);

         System.out.println(result.toString());
     }
}