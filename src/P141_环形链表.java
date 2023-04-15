import java.util.List;

public class P141_环形链表 {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = null;
        if(slow != null) {
            quick = slow.next;
        }
        while (quick != null && quick != slow) {
            slow = slow.next;
            quick = quick.next;
            if(quick != null) {
                quick = quick.next;
            }
        }
        if(quick == null || slow == null) {
            return false;
        }
        return true;
    }
}
