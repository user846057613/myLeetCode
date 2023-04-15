public class P面试题55Ⅰ_二叉树的深度 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root,1);
    }

    private int dfs(TreeNode root, int level) {
        if(root != null) {
            return Math.max(dfs(root.left,level+1), dfs(root.right,level+1));
        }
        return level-1;
    }
}
