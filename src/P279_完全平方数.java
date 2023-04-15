import java.util.Arrays;

public class P279_完全平方数 {
    public int numSquares(int n) {
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                int num = j*j;
                dp[i] = Math.min(dp[i], dp[i-num] + 1);
            }
        }
        return dp[n];
    }
}
