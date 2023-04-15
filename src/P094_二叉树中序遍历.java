import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P094_二叉树中序遍历 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class ColorNode {
        String color;
        TreeNode treeNode;

        public ColorNode(String color, TreeNode treeNode) {
            this.color = color;
            this.treeNode = treeNode;
        }
    }

    public List<Integer> inorderTravelsal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root != null) {
            LinkedList<ColorNode> colorNodes = new LinkedList<>();
            ColorNode node = new ColorNode("WHITE", root);
            colorNodes.add(node);
            while (!colorNodes.isEmpty()) {
                ColorNode colorNode = colorNodes.pop();
                if(colorNode.treeNode == null) {
                    continue;
                } else {
                    if("WHITE".equals(colorNode.color)) {
                        if (colorNode.treeNode.right != null) {
                            colorNodes.add(new ColorNode("WHITE", colorNode.treeNode.right));
                        }
                        colorNode.color = "GRAY";
                        colorNodes.add(colorNode);
                        if (colorNode.treeNode.left != null) {
                            colorNodes.add(new ColorNode("WHITE", colorNode.treeNode.left));
                        }
                    }else {
                        res.add(colorNode.treeNode.val);
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void mytest(){
//        inorderTravelsal(new TreeNode());
    }
}
