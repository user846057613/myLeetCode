import org.junit.Test;

public class P647_回文子串 {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int ans = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j == i + 1) {
                        dp[i][j] = true;
                        ans++;
                    }else if(dp[i+1][j-1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {

        System.out.println(countSubstrings("aaaaa"));
    }
}
