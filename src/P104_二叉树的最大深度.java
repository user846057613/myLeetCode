public class P104_二叉树的最大深度 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }else {
            int depth = 1;
            depth += Math.max(maxDepth(root.left), maxDepth(root.right));
            return depth;
        }
    }
}
