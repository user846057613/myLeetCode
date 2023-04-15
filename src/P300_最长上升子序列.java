import java.util.Arrays;

public class P300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxnum = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    maxnum = Math.max(dp[j],maxnum);
                }
            }
            dp[i] = maxnum + 1;
            result = Math.max(dp[i], result);
        }
        return  result;
    }
}
