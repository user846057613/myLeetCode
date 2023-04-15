import org.junit.Test;

public class P091_解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        if(s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            dp[1] = 1;
        }
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9' &&
            s.charAt(i-1) =='1') {
                dp[i+1] = dp[i] + dp[i-1];
            }else if(s.charAt(i) >= '1' && s.charAt(i) <= '6' && s.charAt(i-1) == '2') {
                dp[i+1] = dp[i] + dp[i-1];
            }
            else if(s.charAt(i) == '0') {
                if(s.charAt(i-1) >= '1' && s.charAt(i-1) <= '2') {
                    dp[i+1] = dp[i-1];
                }else{
                    dp[n] = 0;
                    break;
                }
            }else {
                dp[i+1] = dp[i];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numDecodings("17")
        );
    }
}
