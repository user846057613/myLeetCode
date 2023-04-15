public class P437_路径总和Ⅲ {

    public class TreeNode {
     int val;
     TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    private int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root != null) {
            Sum(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return ans;
    }
    public void Sum(TreeNode root, int sum) {
        if(root == null) return;
        sum -= root.val;
        if(sum == 0) {
            ans++;
        }
        Sum(root.left, sum);
        Sum(root.right,sum);
    }
}
