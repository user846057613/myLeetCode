import org.junit.Test;

import java.util.Stack;

public class P445_两数相加Ⅱ {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<ListNode> ans = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int in = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode a = s1.pop();
            ListNode b = s2.pop();
            int sum = a.val + b.val + in;
            in = 0;
            if(sum >= 10) {
                sum = sum % 10;
                in = 1;
            }
            ans.push(new ListNode(sum));
        }
        while (!s1.isEmpty()) {
            ListNode a = s1.pop();
            int sum = a.val + in;
            in = 0;
            if(sum >= 10) {
                sum = sum % 10;
                in = 1;
            }
            ans.push(new ListNode(sum));
        }
        while (!s2.isEmpty()) {
            ListNode a = s2.pop();
            int sum = a.val + in;
            in = 0;
            if(sum >= 10) {
                sum = sum % 10;
                in = 1;
            }
            ans.push(new ListNode(sum));
        }
        if(in > 0) ans.push(new ListNode(1));
        ListNode head = new ListNode(0);
        ListNode nextNode = head;
        while (!ans.isEmpty()) {
            ListNode node = ans.pop();
            nextNode.next = node;
            nextNode = nextNode.next;
        }
        return head.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode n1 = reverseList(l1);
        ListNode n2 = reverseList(l2);
        ListNode head = new ListNode(0);
        ListNode node = head;
        int in = 0;
        while (n1 != null && n2 != null) {
            int sum = n1.val + n2.val + in;
            in = 0;
            if(sum >= 10) {
                in = 1;
                sum = sum % 10;
            }
            ListNode node1 = new ListNode(sum);
            node.next = node1;
            node = node.next;
            n1 = n1.next;
            n2 = n2.next;
        }
        if(n1 != null) {
            ListNode tmp = n1;
            while (in > 0 && tmp != null) {
                if(tmp.val == 9) {
                    tmp.val = 0;
                    in = 1;
                    tmp = tmp.next;
                }else{
                    tmp.val++;
                    in = 0;
                }
            }
            node.next = n1;
        }else if(n2 != null) {
            ListNode tmp = n2;
            while (in > 0 && tmp != null) {
                if(tmp.val == 9) {
                    tmp.val = 0;
                    in = 1;
                    tmp = tmp.next;
                }else{
                    tmp.val++;
                    in = 0;
                }
            }
            node.next = n2;
        }
        if( in > 0) {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(1);
        }
        return reverseList(head.next);
    }

    private ListNode reverseList(ListNode root) {
        ListNode node = root;
        ListNode pre = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode a, b ,c,d,e,f,g;
        a = new ListNode(5);
        f = new ListNode(6);
        g = new ListNode(4);
        b = new ListNode(7);
        c = new ListNode(2);
        d = new ListNode(4);
        e = new ListNode(3);
        b.next = c;
        c.next = d;
        d.next = e;
        a.next = f;
        f.next = g;
        addTwoNumbers(a,b);
    }
}
