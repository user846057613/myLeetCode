public class P面试题0205_链表求和 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int in = 0;
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + in;
            in = num / 10;
            num = num % 10;
            node.next = new ListNode(num);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int num = l1.val  + in;
            in = num / 10;
            num = num % 10;
            node.next = new ListNode(num);
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int num = l2.val  + in;
            in = num / 10;
            num = num % 10;
            node.next = new ListNode(num);
            node = node.next;
            l2 = l2.next;
        }
        if(in > 0) node.next = new ListNode(1);
        return ans.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}
