import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class P295_数据流的中位数 {
    class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    Node head, tail;
    Node mid;
    int size;
    /** initialize your data structure here. */
    public P295_数据流的中位数() {
        head = new Node(0);
        tail = new Node(0);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        size = 0;
    }
    public void insert(Node left, Node insert, Node right) {
        left.next = insert;
        insert.prev = left;
        insert.next = right;
        right.prev = insert;
    }
    public void addNum(int num) {
        size++;
        boolean flag = true;
        if(size % 2 == 0) {
            flag = false;
        }
        Node insertNode = new Node(num);
        if(size == 1) {
            insert(head,insertNode,tail);
            mid = insertNode;
        }else{
            Node node = mid;
            if(num > mid.val) {
                while (num > node.val && node.next != tail) {
                    node = node.next;
                }
                if(num > node.val) {
                    insert(node, insertNode,tail);
                }else{
                    insert(node.prev, insertNode, node);
                }
                mid = flag == false ? mid : mid.next;
            }else{
                while (num <= node.val && node.prev != head) {
                    node = node.prev;
                }
                if(num <= node.val) {
                    insert(head, insertNode,node);
                }else{
                    insert(node, insertNode, node.next);
                }
                mid = flag == false ? mid.prev : mid;
            }
        }
    }

    public double findMedian() {
        if(size == 0) {
            return 0.0;
        }else{
            if(size % 2 != 0) {
                return mid.val;
            }else{
                return (mid.val + mid.next.val) * 0.5;
            }
        }
    }

    @Test
    public void test() {
        P295_数据流的中位数 a = new P295_数据流的中位数();
        a.addNum(1);
        a.addNum(2);
        System.out.println(findMedian());
    }
}
