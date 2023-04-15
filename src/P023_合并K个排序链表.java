import java.util.*;

public class P023_合并K个排序链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class CompareListNode implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val < o2.val ? -1 : (o1.val == o2.val? 0 : 1);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length != 0) {
            if(lists.length == 1) {
                return lists[0];
            }
            Arrays.sort(lists, new CompareListNode());
            ListNode l1 = lists[0];
            for (int i = 1; i < lists.length; i++) {
                l1 = mergeTwoList(l1, lists[i]);
            }
            return l1;
        }
        return null;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                l1.next = mergeTwoList(l1.next, l2);
                return l1;
            }else {
                l2.next = mergeTwoList(l2.next, l1);
                return l2;
            }
        }else if( l1 != null && l2 == null) {
            return l1;
        }else if(l1 == null && l2 != null) {
            return l2;
        }else {
            return null;
        }
    }
}
