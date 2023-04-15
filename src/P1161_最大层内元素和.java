import java.util.LinkedList;

public class P1161_最大层内元素和 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int maxLevelSum(TreeNode root) {
        if(root != null) {
            int max = Integer.MIN_VALUE;
            int ans = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                int sum = 0;
                for (int i = 0; i < sz; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                if(sum > max) {ans = level; max = sum;}
                level++;
            }
            return ans;
        }
        return 1;
    }
}
