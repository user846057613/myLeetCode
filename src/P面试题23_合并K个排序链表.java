import java.util.Comparator;
import java.util.PriorityQueue;

public class P面试题23_合并K个排序链表 {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode n = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            n.next = node;
            n = n.next;
        }
        n.next = null;
        return head.next;
    }
}
