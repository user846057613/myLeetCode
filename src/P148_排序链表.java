import org.junit.Test;

public class P148_排序链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
             return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next!= null && quick.next.next!= null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode nMid = slow.next;
        slow.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(nMid);
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                node.next = n1;
                node = node.next;
                n1 = n1.next;
            }else {
                node.next = n2;
                node = node.next;
                n2 = n2.next;
            }
        }
        if(n1 != null) {
            node.next = n1;
        }
        if(n2 != null) {
            node.next = n2;
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        sortList(a);

    }
}
