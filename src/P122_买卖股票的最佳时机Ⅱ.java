import org.junit.Test;

public class P122_买卖股票的最佳时机Ⅱ {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        if(n == 0) {
            return 0;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][0] = Math.max(dp[i][0], dp[j][1]);
                dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0], dp[j][0] + prices[i]-prices[j]));
            }
            dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1],dp[n-1][2]));
    }

    @Test
    public void test() {
        int[] num = {7,1,5,3,6,4};
        System.out.println(maxProfit(num));
    }
}
