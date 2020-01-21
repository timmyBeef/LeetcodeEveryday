package leetcode.list;
/*
    141. Linked List Cycle
    https://leetcode.com/problems/linked-list-cycle/

    一樣用快慢指針, 快的會跟慢的記憶體位置一樣的話, 代表有cycle
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;

        while(walker != null && runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) {
                return true;
            }
        }

        return false;
    }
}
