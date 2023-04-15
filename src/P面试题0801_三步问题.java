import org.junit.Test;

import java.util.Stack;

public class P面试题0801_三步问题 {
    public int waysToStep(int n) {
        int[] dp = new int[n+1];
        if(n >= 1) {
            dp[1] = 1;
        }
        if(n >= 2) {
            dp[2] = 2;
        }
        if(n >= 3) {
            dp[3] = 4;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-1] + dp[i-2])%1000000007 + dp[i-3])%1000000007;
        }
        return dp[n];
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                }else{
                    if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = dp[i-1] + (i - dp[i-1] - 2 >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }

    @Test
    public void test() {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
