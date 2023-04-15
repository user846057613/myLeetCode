public class AVL树 {
    class TreeNode{
        int val;
        int bf;
        TreeNode left;
        TreeNode right;
    }

    public void rotationLL(TreeNode root, TreeNode b) {
        root.left = b.right;
        root.bf = 0;
        b.right = root;
        b.bf = 0;
    }

    public void rotationLR(TreeNode root, TreeNode b) {
        TreeNode c = b.right;
        root.left = c.right;
        b.right = c.left;
        c.right = root;
        c.left = b;
        if(c.bf == 1) {
            root.bf = -1;
            b.bf = 0;
        }else if(c.bf == 0){
            root.bf = 0;
            b.bf = 0;
        }else if(c.bf == -1) {
            root.bf = 0;
            b.bf = 1;
        }
        c.bf = 0;
        b = c;
    }

    public void rotationRR(TreeNode root, TreeNode b) {
        root.right = b.left;
        root.bf = 0;
        b.left = root;
        b.bf = 0;
    }

    public void rotationRL(TreeNode root, TreeNode b) {
        TreeNode c = b.left;
        root.right = c.left;
        b.left = c.right;
        c.left = root;
        c.right = b;
        if(c.bf == 1) {
            root.bf = 0;
            b.bf = -1;
        }else if(c.bf == 0) {
            root.bf = 0;
            b.bf = 0;
        }else if(c.bf == -1) {
            root.bf = 1;
            b.bf = 0;
        }
        c.bf = 0;
        b = c;
    }
}
