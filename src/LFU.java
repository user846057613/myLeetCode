import java.util.HashMap;

public class LFU {
    HashMap<Integer, Node> cache;
    HashMap<Integer, MyDeque> timeCache;
    int min;
    int capacity;
    int size;

    public LFU(int capacity) {
        cache = new HashMap<>();
        timeCache = new HashMap<Integer, MyDeque>();
        min = 0;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        rePut(node);
        return node.val;
    }

    public int put(int key, int val) {
        if(capacity == 0) {
            return -1;
        }
        Node node = new Node(key,val, 1);
        int oldVal = val;
        if(cache.containsKey(key)){
            node = cache.get(key);
            oldVal = node.val;
            node.val = val;
            rePut(node);
        }else{
            if(size == capacity) {
                MyDeque queue = timeCache.get(min);
                Node removeNode = queue.removeLast();
                cache.remove(removeNode.key);
                oldVal = removeNode.val;
                size--;
            }
            MyDeque queue = timeCache.get(1);
            if(queue == null) {
                queue = new MyDeque();
                timeCache.put(1,queue);
            }
            queue.addFirst(node);
            cache.put(key, node);
            size++;
            min = 1;
        }
        return oldVal;
    }

    public void rePut(Node node) {
        if(node != null) {
            MyDeque queue = timeCache.get(node.times);
            queue.remove(node);
            if(node.times == min && queue.size == 0){
                min++;
            }
            node.times++;
            queue = timeCache.get(node.times);
            if(queue == null) {
                queue = new MyDeque();
                timeCache.put(node.times, queue);
            }
            queue.addFirst(node);
        }
    }
}

class MyDeque{
    Node head, tail;
    int size;

    public MyDeque() {
        head = new Node(0,0,0);
        tail = new Node(0,0,0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }

    public Node removeLast() {
        if(size == 0) return null;
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        size--;
        return node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
}

class Node{
    int key;
    int val;
    int times;
    Node next, prev;
    public Node(int key,int val,int times) {
        this.key = key;
        this.val = val;
        this.times = times;
    }
}