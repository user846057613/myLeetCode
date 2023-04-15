import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P103_二叉树的锯齿形层次遍历 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root != null) {
            int level = 1;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            List<Integer> list;
            Stack<TreeNode> stack1 = new Stack<>();
            while (!stack.isEmpty()) {
                int size = stack.size();
                list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if(level % 2 != 0) {
                        if(node.left != null) {
                            stack1.push(node.left);
                        }
                        if(node.right != null) {
                            stack1.push(node.right);
                        }
                    }else{
                        if(node.right != null) {
                            stack1.push(node.right);
                        }
                        if(node.left != null) {
                            stack1.push(node.left);
                        }
                    }
                }
                ans.add(list);
                level++;
                stack.addAll(stack1);
                stack1.clear();
            }
        }
        return ans;
    }
}
