import org.junit.Test;

public class P1008_先序遍历构造二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;
        int pos = 0;
        for (int i = 0; i < preorder.length; i++) {
            if(preorder[i] > preorder[0]) {
                pos = i;
                break;
            }
        }
        pos = pos == 0 ? preorder.length : pos;
        int lengthL = pos - 1;
        int lengthR = preorder.length - pos;
        int[] leftPreorder = new int[lengthL];
        int[] rightPreorder = new int[lengthR];
        System.arraycopy(preorder,1,leftPreorder,0,lengthL);
        System.arraycopy(preorder,pos,rightPreorder,0,lengthR);
        root.left = bstFromPreorder(leftPreorder);
        root.right = bstFromPreorder(rightPreorder);
        return root;
    }

    @Test
    public void test() {
        int[] num = {4,2};
        bstFromPreorder(num);
    }
}
