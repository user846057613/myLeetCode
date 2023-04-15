import java.util.List;

public class P142_环形链表Ⅲ {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode intersact = getIntersact(head);
        if(intersact == null) {
            return null;
        }
        ListNode node = head;
        while (node != intersact) {
            node = node.next;
            intersact = intersact.next;
        }
        return node;
    }

    private ListNode getIntersact(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick) {
                return quick;
            }
        }
        return null;
    }
}
