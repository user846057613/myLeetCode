public class P053_最大子序和 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxnum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            maxnum = Math.max(sum, maxnum);
        }
        return maxnum;
    }
}
