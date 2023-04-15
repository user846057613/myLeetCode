import java.util.List;

public class P142_环形链表Ⅱ {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = null;
        if(slow != null) {
            quick = slow.next;
        }
        while (quick != null && slow != quick) {
            slow = slow.next;
            quick = quick.next;
            if(quick != null) {
                quick = quick.next;
            }
        }
        if(quick != null) {
            ListNode node = head;
            quick = quick.next;
            while( node != quick) {
                node = node.next;
                quick = quick.next;
            }
        }
        return quick;
    }
}
