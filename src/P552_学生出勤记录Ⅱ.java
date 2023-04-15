public class P552_学生出勤记录Ⅱ {
    public int checkRecord1(int n) {
        long[][][] dp = new long[n+1][2][3];
        if(n == 0) return 0;
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2])% 1000000007;
            dp[i][0][1] = dp[i-1][0][0] % 1000000007;
            dp[i][0][2] = dp[i-1][0][1] % 1000000007;
            dp[i][1][0] = (dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2] +
                    dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2])% 1000000007;
            dp[i][1][1] = dp[i-1][1][0] % 1000000007;
            dp[i][1][2] = dp[i-1][1][1] % 1000000007;
        }
        return (int)((dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1]
                + dp[n][1][2]) % 1000000007);
    }

    public int checkRecord(int n) {
        long[][][] dp = new long[n+1][2][3];
        if(n == 0) return 0;
        long dp00 = 1;
        long dp10 = 1;
        long dp01 = 1;
        long dp02 = 0;
        long dp11 = 0;
        long dp12 = 0;
        long pre11 = 0;
        long pre10 = 0;
        long pre12 = 0;
        long pre00 = 0;
        long pre01 = 0;
        long pre02 = 0;
        for (int i = 2; i <= n; i++) {
            pre11 = dp11;
            pre10 = dp10;
            pre12 = dp12;
            pre00 = dp00;
            pre01 = dp01;
            pre02 = dp02;
            dp12 = pre11 % 1000000007;
            dp11 = pre10 % 1000000007;
            dp10 = pre10 + pre11 + pre12 + dp00 + dp01 + dp02;
            dp00 = ( pre00 + pre01 + pre02 ) % 1000000007;
            dp01 = pre00 % 1000000007;
            dp02 = pre01 % 1000000007;
        }
        return (int)((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % 1000000007);
    }
}
