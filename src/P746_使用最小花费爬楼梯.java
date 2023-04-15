public class P746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        if(n > 1) dp[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            int thisCos = i == n ? 0 : cost[i];
            dp[i] = Math.min(dp[i-1],dp[i-2]) + thisCos;
        }
        return dp[n];
    }
}
