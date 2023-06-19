import org.junit.Test;

public class P147_对链表进行插入排序 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode lastSorted = head;
        ListNode curr = head.next;

        while(curr != null) {
            if(lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummy;
                while(pre.next.val <= curr.val) {
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }

        return dummy.next;
    }

}
