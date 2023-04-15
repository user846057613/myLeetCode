import sun.reflect.generics.tree.Tree;

import java.util.Map;

public class P236_二叉树的最近公共祖先 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isChild(p, q)) {
            return p;
        }else if(isChild(q, p)) {
            return q;
        }else {
            TreeNode pA = search(root, p);
            TreeNode qA = search(root, q);
            if(pA != qA) {
                TreeNode result = lowestCommonAncestor(root, pA, qA);
                return result;
            }else {
                return pA;
            }
        }
    }

    public boolean isChild(TreeNode a, TreeNode b) {
        if(a != null) {
            if(b == a.left || b == a.right) {
                return true;
            }else{
                return isChild(a.left, b) || isChild(a.right, b);
            }
        }
        return false;
    }

    public TreeNode search(TreeNode root, TreeNode child) {
        if(root != null) {
            if(root.left == child || root.right == child) {
                return root;
            }else{
                TreeNode node1 = search(root.left, child);
                if(node1 != null && (node1.left == child || node1.right == child)) {
                    return node1;
                }
                TreeNode node2 = search(root.right, child);
                if(node2 != null && (node2.left == child || node2.right == child)) {
                    return node2;
                }
                return null;
            }
        }else{
            return null;
        }
    }
}
