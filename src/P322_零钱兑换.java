import org.junit.Test;

import java.util.Arrays;

public class P322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int ans = 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            int minnum = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    if(dp[i-coins[j]] > -1) {
                        minnum = Math.min(dp[i-coins[j]]+1, minnum);
                    }
                }else {
                    break;
                }
            }
            if(minnum != Integer.MAX_VALUE) {
                dp[i] = minnum;
            }
        }
        return dp[amount];
    }

    @Test
    public  void test() {
        int[] num = {1,2,5};
        int amount = 11;
        int result = coinChange(num,amount);
        System.out.println(result);
    }
}
