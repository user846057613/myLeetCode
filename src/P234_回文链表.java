import java.util.Arrays;

public class P234_回文链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode firstPart = findFirstPart(head);
        ListNode secondPart = reverseList(firstPart.next);

        ListNode p1 = head, p2 = secondPart;
        boolean ans = true;
        while (p1 != null && p2 != null) {
            if(p1.val != p2.val) {
                ans = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        firstPart.next = reverseList(secondPart);
        return ans;
    }

    public ListNode findFirstPart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while(node != null) {
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }

}
