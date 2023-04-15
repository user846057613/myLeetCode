import org.junit.Test;

public class P099_恢复二叉搜索树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode preNode = null;
    TreeNode lowerNode = null;
    TreeNode higherNode = null;

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode head = root;
        findTree(head);
        if(higherNode == null) {
            higherNode = root;
        }

        if(lowerNode != null && higherNode != null) {
            int tmp = lowerNode.val;
            lowerNode.val = higherNode.val;
            higherNode.val = tmp;
        }
    }

    public void findTree(TreeNode root) {
        if(root == null) {
            return;
        }

        recoverTree(root.left);

        if(preNode != null && root.val < preNode.val) {
            if(lowerNode == null) {
                lowerNode = preNode;
            }else if(higherNode == null) {
                higherNode = root;
            }
        }

        if(lowerNode != null && higherNode != null) {
            return;
        }

        preNode = root;
        recoverTree(root.right);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node2.right = node3;
        recoverTree(node1);
    }
}
