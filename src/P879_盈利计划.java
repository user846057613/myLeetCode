import java.util.Arrays;

public class P879_盈利计划 {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1000000007;
        int len = profit.length;
        int[][] dp = new int[G+1][P+1];
        int[][] dp_copy = new int[G+1][P+1];
        dp[0][0] = 1;
        for (int k = 0; k < len; k++) {
            for (int j = 0; j < G+1; j++) {
                Arrays.fill(dp_copy[j],0);
            }

            for (int i = 0; i <= G-group[k]; i++) {
                for (int j = 0; j <= P; j++) {
                    dp_copy[i+group[k]][Math.min(P,j+profit[k])] =
                            ( dp_copy[i+group[k]][Math.min(P,j+profit[k])] + dp[i][j] ) % mod;
                }
            }

            for (int i = 0; i <= G; i++) {
                for (int j = 0; j <= P; j++) {
                    dp[i][j] = (dp[i][j] + dp_copy[i][j]) % mod;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= G; i++) {
            res = (res + dp[i][P]) % mod;
        }
        return res;
    }
}
