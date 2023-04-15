import java.util.HashMap;

public class LRU {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return  -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node x = new Node(key, val);
        if(map.containsKey(key)) {
            cache.remove(map.get(key));
        }else {
            if(capacity == cache.getSize()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);
        map.put(key, x);
    }


    class Node{
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    class DoubleList{
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        //在链表头部添加结点x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        //删除列表中的x结点(x一定存在)
        public void remove(Node x) {
            x.next.prev = x.prev;
            x.prev.next = x.next;
            size--;
        }

        //删除链表中最后一个结点，并返回该节点
        public Node removeLast() {
            if(tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int getSize() {
            return size;
        }
    }
}
