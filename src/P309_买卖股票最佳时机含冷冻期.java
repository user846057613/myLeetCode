public class P309_买卖股票最佳时机含冷冻期 {

    /***
     * 状态转移方程
     *
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i] )
     * 第i天不持有股票最大收益= 最大收益(第i-1天不持有股票， 第i-1天持有股票+第i天卖掉的利润）
     * dp[i][1] = max(dp[i-1][1], max(dp[i-2][0], dp[i-2][1]+prices[i-1]) - prices[i])
     *          = max(dp[i-1][1], dp[i-2][0] - prices[i])
     * 第i天持有股票最大收益= 最大收益(第i-1天持有股票， 第i-1天不持有股票+第i天卖掉的利润）
     * 其中由于有冷冻期，所以可以化简为上述式子
     * 也可以理解为，要使的能在第i天买入股票，如果有冷冻期，则最晚在第i-1天，那么第i-2天卖掉股票，第i-2天不持有股票
     *
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        if (n == 0) {
            return 0;
        }
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        if (n > 1) {
            dp[1][0] = Math.max(0, prices[1] - prices[0]);
            dp[1][1] = Math.max(dp[0][1], -prices[1]);
        }
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public void maxProfitWithCooldown(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_i2_0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i2_0 - prices[i]);
            dp_i2_0 = temp;
        }
    }
}
