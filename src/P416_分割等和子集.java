public class P416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return false;
        }
        int v = sum / 2;
        boolean[][] dp = new boolean[nums.length][v+1];

        if(nums[0] <= v) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i]; j <= v; j++) {
                if(nums[i] == j) {
                    dp[i][j] = true;
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][v];
    }
}
