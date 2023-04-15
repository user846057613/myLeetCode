public class 面试题0811硬币 {
    public int waysToChange(int n) {
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        int[] money = {1,5,10,25};
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j-money[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
