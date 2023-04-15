import java.util.Arrays;

public class P108_将有序数组转换为二叉搜索树 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        TreeNode root = null;
        int n = nums.length;
        int mid = n/2;
        root = new TreeNode(nums[mid]);
        if(mid > 0) {
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        }
        if(mid+1 < n) {
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,n));
        }
        return root;
    }
}
