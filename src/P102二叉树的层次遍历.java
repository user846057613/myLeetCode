import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102二叉树的层次遍历 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    class NewNode{
        TreeNode node;
        int level;

        public NewNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> PrelevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return  res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.get(level).add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            LinkedList<NewNode> queue = new LinkedList<>();
            queue.offer(new NewNode(0, root));
            ArrayList<Integer> inRes = new ArrayList<>();
            int level = 0;
            while(!queue.isEmpty()) {
                NewNode node = queue.poll();
                if(node.level != level) {
                    level = node.level;
                    res.add(inRes);
                    inRes = new ArrayList<>();
                }
                inRes.add(node.node.val);
                if(node.node.left != null) {
                    queue.offer(new NewNode(node.level + 1, node.node.left));
                }
                if(node.node.right != null) {
                    queue.offer(new NewNode(node.level + 1, node.node.right));
                }
            }
            if(!inRes.isEmpty()) {
                res.add(inRes);
            }
        }

        return res;
    }
}
