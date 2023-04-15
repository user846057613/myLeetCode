public class P494_目标和 {
    int ans = 0;
    int S;
    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        temp(nums,0,0);
        return ans;
    }

    private void temp(int[] nums, int start, int sum) {
        if(start == nums.length) {
            if(sum == S) {
                ans++;
            }
            return;
        }
        temp(nums, start + 1, sum + nums[start]);
        temp(nums, start + 1, sum - nums[start]);
    }
}
