import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class P538_把二叉搜索树转换为累加数 {

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
    public ArrayList<Integer> inorder = new ArrayList<>();
    public ArrayList<Integer> sum = new ArrayList<>();
    public int num = 0;


    public TreeNode convertBSTNew(TreeNode root) {
        if(root != null) {
            if(root.right != null) {
                convertBSTNew(root.right);
            }
            root.val += num;
            num = root.val;
            if(root.left != null) {
                convertBSTNew(root.left);
            }
        }
        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        inorderSearch(root);
        Collections.sort(inorder);
        sum.addAll(inorder);
        sum.set(inorder.size()-1, inorder.get(inorder.size()-1));
        for (int i = inorder.size()-2; i >= 0; i--) {
            sum.set(i, inorder.get(i) + sum.get(i+1));
        }
        return rebuild(root);
    }

    private TreeNode rebuild(TreeNode root) {
        int index = Collections.binarySearch(inorder, root.val);
        for (int i = index+1; i < inorder.size(); i++) {
            if(inorder.get(i) == root.val) {
                index = i;
            }else {
                break;
            }
        }
        root.val = sum.get(index);
        if(root.left != null) {
            rebuild(root.left);
        }
        if(root.right != null) {
            rebuild(root.right);
        }
        return root;
    }

    public void inorderSearch(TreeNode root) {
        if(root.left != null) {
            inorderSearch(root.left);
        }
        inorder.add(root.val);
        if(root.right != null) {
            inorderSearch(root.right);
        }
    }
}
