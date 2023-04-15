public class P226_翻转二叉树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = left;
            root.left = right;
            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }
}
