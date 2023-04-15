import org.junit.Test;

public class P044_通配符匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        System.out.println(isMatch("a", "a*"));
    }
}
