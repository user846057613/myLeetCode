import java.util.ArrayList;

public class P230_二叉搜索树中第k小的元素 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int count;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        if(root != null) {
            if(root.left != null && count != k) {
                kthSmallest(root.left, k);
            }
            if(count < k) {
                count++;
                ans = root.val;
            }
            if(root.right != null && count != k) {
                kthSmallest(root.right, k);
            }
        }
        return ans;
    }

    public int kthSmallest1(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root != null) {
            ans = helper(root);
            return ans.get(k-1);
        }
        return 0;
    }

    private ArrayList<Integer> helper(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root!=null) {
            ans.addAll(helper(root.left));
            ans.add(root.val);
            ans.addAll(helper(root.right));
        }
        return ans;
    }


}
