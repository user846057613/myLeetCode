import java.util.ArrayList;

public class BST树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public void insertBST(TreeNode node, TreeNode root) {
        if(root == null) {
            root = node;
        }else if(node.val > root.val) {
            insertBST(node,root.right);
        }else {
            insertBST(node,root.left);
        }
    }

    public TreeNode makeBST(ArrayList<TreeNode> nodeList, TreeNode root) {
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode now = nodeList.get(i);
            insertBST(now, root);
        }
        return root;
    }

    public void deleteBST(TreeNode parent, TreeNode node) {
        if(node.left == null) {
            if(parent == null) parent = node.right;
            else if(parent.left == node) parent.left = node.right;
            else if(parent.right == node) parent.right = node.right;
        }else if(node.right == null) {
            if(parent == null) parent = node.left;
            else if(parent.left == node) parent.left = node.left;
            else if(parent.right == node) parent.right = node.left;
        }else {
            TreeNode findRight = node.left;
            while (findRight != null) {
                findRight = findRight.right;
            }
            if(parent == null) parent = node.left;
            else if(parent.left == node) parent.left = node.left;
            else if(parent.right == node) parent.right = node.left;
            findRight.right = node.right;
        }
    }
}
