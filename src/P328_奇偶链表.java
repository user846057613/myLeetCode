import org.junit.Test;

public class P328_奇偶链表 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
    public ListNode oddEvenList(ListNode head) {
        if(head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    @Test
    public void test(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(oddEvenList(a));
    }
}
