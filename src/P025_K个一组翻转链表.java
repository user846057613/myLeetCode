public class P025_K个一组翻转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        int index = 0;
        ListNode node = head;
        ListNode result = null;
        ListNode endNode = head;
        ListNode pre = null;
        while (endNode != null) {
            index++;
            if(index == k) {
                ListNode temp = endNode.next;
                ListNode[] reverse = reverseList(node,temp);
                if(pre != null){
                    pre.next = reverse[0];
                }
                pre = reverse[1];
                pre.next = temp;
                node = temp;
                endNode = temp;
                index = 0;
                if(result == null) result = reverse[0];
            }else{
                endNode = endNode.next;
            }
        }
        return result;
    }

    private ListNode[] reverseList(ListNode startNode, ListNode endNode) {
        ListNode pre = null;
        ListNode node = startNode;
        while (node != endNode) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return new ListNode[]{pre, startNode};
    }
}
