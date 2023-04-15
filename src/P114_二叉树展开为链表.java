import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P114_二叉树展开为链表 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if(root != null) {
            arrange(root);
        }
    }

    public void arrange(TreeNode root) {
        if(root != null) {
            TreeNode node = root.right;
            root.right = root.left;
            root.left = null;
            arrange(root.right);
            while(root.right != null) {
                root = root.right;
            }
            root.right = node;
            arrange(root.right);
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        flatten2(node1);

    }

    public void flatten2(TreeNode root) {
        if(root != null) {
            TreeNode right = root.right;
            if(root.left != null) {
                flatten2(root.left);
                root.right = root.left;
                root.left = null;
            }

            while(root.right != null) {
                root = root.right;
            }
            if(right != null) {
                flatten2(right);
                root.right = right;
            }
        }
    }
}
