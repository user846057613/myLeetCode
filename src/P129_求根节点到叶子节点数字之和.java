import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class P129_求根节点到叶子节点数字之和 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(sumNumbers(root));
    }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int tmp) {
        if(root == null) {
            return 0;
        }
        int nextTmp = 10 * tmp + root.val;
        if(root.left == null && root.right == null) {
            return nextTmp;
        }

        return helper(root.left, nextTmp) + helper(root.right, nextTmp);
    }


    public int sumNumbers1(TreeNode root) {
        List<String> allNums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append((char)('0' + root.val));
        trival(allNums, sb, root);

        int sum = allNums.stream().mapToInt(Integer::parseInt).sum();
        return sum;
    }

    public void trival(List<String> allNums, StringBuilder sb, TreeNode root) {
        if(root.left == null && root.right == null && sb.length() != 0) {
            allNums.add(sb.toString());
            return;
        }

        if(root.left != null) {
            sb.append((char)('0' + root.left.val));
            trival(allNums, sb, root.left);
            sb.deleteCharAt(sb.length()-1);
        }

        if(root.right != null) {
            sb.append((char)('0' + root.right.val));
            trival(allNums, sb, root.right);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
