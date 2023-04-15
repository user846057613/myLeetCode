import java.util.LinkedList;

public class P116_填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if(root != null) {
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(root);
            LinkedList<Node> next = new LinkedList<>();
            Node node1, node2;
            while (!queue.isEmpty()) {
                node1 = queue.poll();
                node2 = queue.isEmpty() ? null : queue.peek();
                node1.next = node2;
                if(node1.left != null) {
                    next.offer(node1.left);
                }
                if(node1.right != null) {
                    next.offer(node1.right);
                }
                if(node2 == null) {
                    queue.addAll(next);
                    next.clear();
                }
            }
        }
        return root;
    }
}
