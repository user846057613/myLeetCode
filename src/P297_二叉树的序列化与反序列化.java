import org.junit.Test;

import java.util.*;

public class P297_二叉树的序列化与反序列化 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root != null) {
            return front(root);
        }
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] frontString = data.split(",");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < frontString.length; i++) {
            queue.offer(frontString[i]);
        }
        return constructTree(queue);
    }

    public TreeNode constructTree(LinkedList<String> queue) {

        if(queue.isEmpty()) {
            return null;
        }else{
            String s = queue.poll();
            if(s.equals("none")) {
                return null;
            }else {
                TreeNode node = new TreeNode(Integer.parseInt(s));
                node.left = constructTree(queue);
                node.right = constructTree(queue);
                return node;
            }
        }
    }

    public String front(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root != null) {
            sb.append( root.val+ ",");
            sb.append(front(root.left));
            sb.append(front(root.right));
        }else {
            sb.append("none,");
        }
        return sb.toString();
    }
    @Test
    public void mytest() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        String s = serialize(a);
        System.out.println(s);
        TreeNode n = deserialize(s);
    }
}
