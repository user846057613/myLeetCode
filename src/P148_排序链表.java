import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P148_排序链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode() {
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
             return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next!= null && quick.next.next!= null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode nMid = slow.next;
        slow.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(nMid);
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (n1 != null && n2 != null) {
            if(n1.val < n2.val) {
                node.next = n1;
                node = node.next;
                n1 = n1.next;
            }else {
                node.next = n2;
                node = node.next;
                n2 = n2.next;
            }
        }
        if(n1 != null) {
            node.next = n1;
        }
        if(n2 != null) {
            node.next = n2;
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        sortList(a);
    }

    public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode sorted = head;
        ListNode sortedPre = dummy;

        while(sorted != null && sorted.next != null) {
            ListNode cur = sorted.next;
            ListNode curPre = sortedPre;

            ListNode swapNode = null;
            ListNode swapNodePre = null;
            int minNum = sorted.val;

            while(cur != null) {
                if(cur.val < minNum) {
                    minNum = cur.val;
                    swapNode = cur;
                    swapNodePre = curPre;
                }
                curPre = cur;
                cur = cur.next;
            }

            if(swapNode != null) {
                sorted = swap(sortedPre, sorted, swapNodePre, swapNode);
            }

            sortedPre = sorted;
            sorted = sorted.next;
        }

        return dummy.next;
    }

    public ListNode swap(ListNode sortedPre, ListNode sorted, ListNode swapNodePre, ListNode swapNode) {
        if(swapNodePre == sorted) {
            sorted.next = swapNode.next;
            swapNode.next = sorted;
            sortedPre.next = swapNode;
            return swapNode;
        }

        ListNode sortedNext = sorted.next;
        sorted.next = swapNode.next;
        swapNodePre.next = sorted;
        sortedPre.next = swapNode;
        swapNode.next = sortedNext;
        return swapNode;
    }

    @Test
    public void test2() {
//        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(4);
//        ListNode c = new ListNode(1);
//        a.next = b;
//        b.next = c;
//        c.next = null;
//        sortList2(a);;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        for(int i = 50000; i > 0; i--) {
            ListNode l = new ListNode(i);
            pre.next = l;
            pre = pre.next;
        }
        ListNode head = dummy.next;
        dummy.next = null;
        sortList2(head);
    }


    @Test
    public void  test3() {
        Long x = 10*1250025000L;

        for(long i = 0; i < x; i++) {
            System.out.println(i);
        }
    }
}
