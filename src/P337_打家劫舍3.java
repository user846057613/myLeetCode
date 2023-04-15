import org.junit.Test;

import java.util.ArrayList;

public class P337_打家劫舍3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if(root != null) {
            return search(root);
        }
        return 0;
    }

    private int search(TreeNode root) {
        int ans = 0;
        if(root != null) {
            int left = search(root.left);
            int right = search(root.right);
            ans = Math.max(ans, left + right);
            int leftsLeft = 0;
            int leftsRight = 0;
            int rightsLeft = 0;
            int rightsRight = 0;
            if(root.left != null) {
                leftsLeft = search(root.left.left);
                leftsRight = search(root.left.right);
            }
            if(root.right != null) {
                rightsLeft = search(root.right.left);
                rightsRight = search(root.right.right);
            }
            ans = Math.max(ans, leftsLeft + leftsRight + rightsLeft + rightsRight + root.val);
        }
        return ans;
    }

    @Test
    public void test() {

    }
}
