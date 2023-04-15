import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P199_二叉树的右视图 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                boolean flag = false;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode now = queue.poll();
                    System.out.println(now.val + " " + flag);
                    if(!flag) {
                        ans.add(now.val);
                        flag = true;
                    }
                    if(now.right != null) {
                        queue.offer(now.right);
                    }
                    if(now.left != null) {
                        queue.offer(now.left);
                    }
                }
            }
        }
        return ans;
    }
}
