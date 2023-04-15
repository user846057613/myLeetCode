public class P082_删除排序链表中重复元素Ⅱ {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head != null) {
            ListNode pre = null;
            ListNode node = head;
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                   while (node.next != null && node.val == node.next.val) {
                       node = node.next;
                   }
                   if(node.next == null) {
                       if(pre != null) pre.next = null;
                       else{
                           return null;
                       }
                   }else{
                       if(pre != null) pre.next = node.next;
                       else head = node.next;
                   }
                }else{
                    pre = node;
                }
                node = node.next;
            }
        }
        return head;
    }
}
