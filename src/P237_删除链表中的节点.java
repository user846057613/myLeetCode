public class P237_删除链表中的节点 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void deleteNode(ListNode node) {
        if(node != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
