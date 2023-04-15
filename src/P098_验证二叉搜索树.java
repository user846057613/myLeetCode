import java.util.HashMap;

public class P098_验证二叉搜索树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root != null) {
            return helper(root, null, null);
        }
        return true;
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if(root != null) {
            int val = root.val;
            if(lower != null && val <= lower) return false;
            if(upper != null && val >= upper) return false;
            return helper(root.left, lower, val) && helper(root.right, val, upper);
        }
        return true;
    }
}
