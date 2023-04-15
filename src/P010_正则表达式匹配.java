import org.junit.Test;

public class P010_正则表达式匹配 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if(m == 0 && n == 0) {
            return true;
        }else if(n==0 && m != 0) {
            return false;
        }else {
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                if(i-2 >= 0 && p.charAt(i-1) == '*') {
                    dp[0][i] = dp[0][i-2];
                }else {
                    dp[0][i] = false;
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    }else if(p.charAt(j-1) == '*') {
                        if(j-2 < 0) {
                            dp[i][j] = false;
                        }else{
                            if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                                dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i][j-2];
                            }else {
                                dp[i][j] = dp[i][j-2];
                            }
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }

    @Test
    public void test() {
        String s = "bbbba";
        String p = ".*a*a";
        System.out.println(isMatch(s,p));
    }
}
