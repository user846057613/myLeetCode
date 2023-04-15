public class P543_二叉树的直径 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public int maxnum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root != null) {
            search(root);
            return maxnum - 1;
        }
        return 0;
    }

    public int search(TreeNode root) {
        if(root != null) {
            int left = search(root.left);
            int right = search(root.right);
            if(maxnum < left + right ){
                maxnum = left + right + 1;
            }
            return Math.max(left,right) + 1;
        }
        return 0;
    }
}
