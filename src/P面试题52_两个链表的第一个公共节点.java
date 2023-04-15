public class P面试题52_两个链表的第一个公共节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            if(node1 != null) node1 = node1.next;
            else node1 = headA;

            if(node2 != null) node2 = node2.next;
            else node2 = headB;
        }
        return node1;
    }
}
