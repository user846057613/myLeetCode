import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P019_删除链表的倒数第N个节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, head);
        ListNode node = head;
        int index = 1;
        while (node.next != null) {
            node = node.next;
            map.put(index++, node);
        }
        ListNode l = map.get(map.size()-n);
        ListNode lNext = l.next;
        if(n == 1) {
            if(map.size() == 1) {
                return null;
            }
            ListNode lPre = map.get(map.size()-n-1);
            lPre.next = null;
        }else if(n == map.size()) {
            head = head.next;
        }else {
            ListNode lPre = map.get(map.size()-n-1);
            lPre.next = lNext;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, head);
        ListNode node = head;
        int index = 1;
        while (node.next != null) {
            node = node.next;
            map.put(index++, node);
        }
        ListNode l = map.get(map.size()-n);
        ListNode lNext = l.next;
        ListNode lPre = null;
        if(map.size() - n - 1 >= 0) {
            lPre = map.get(map.size() - n - 1);
        }
        if(lPre != null) {
            lPre.next = lNext;
        }
        if(map.size() == n) {
            head = head.next;
        }
        return head;
    }
}
