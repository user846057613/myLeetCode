import org.junit.Test;

import java.util.Arrays;

public class P105_从前序和中序遍历序列构造二叉树 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
             if(inorder[i] == root.val) {
                 index = i;
                 break;
             }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1 + index),
                Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+index, preorder.length),
                Arrays.copyOfRange(inorder,index+1, inorder.length));
        return root;

    }

    @Test
    public void test() {
        int[] num1 = {3,9,20,15,7};
        int[] num2 = {9,3,15,20,7};
        TreeNode t = buildTree(num1,num2);
        System.out.println(t);
    }
}
