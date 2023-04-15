import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class P312_戳气球 {

    public int maxCoins(int[] nums) {
        if(nums == null) {
            return 0;
        }
        int length = nums.length;
        int[] num2 = new int[length+2];
        System.arraycopy(nums,0,num2,1,length);
        num2[0] = 1;
        num2[length+1] = 1;
        length = num2.length;
        int[][] coins = new int[length][length];
        int[][] dp = new int[length][length];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(coins[i],0);
            Arrays.fill(dp[i], 0);
        }
//        for (int i = length-2; i > -1; i--) {
//            for (int j = i + 2; j < length; j++) {
//                int max = 0;
//                for (int k = i+1; k < j; k++) {
//                    int temp = dp[i][k] + dp[k][j] + num2[i]*num2[j]*num2[k];
//                    if(temp > max) {
//                        max = temp;
//                    }
//                }
//                dp[i][j] = max;
//            }
//        }
//        return dp[0][length-1];
    
        return getMaxCoins(num2, 0, length-1, coins);
    }

    private int getMaxCoins(int[] nums, int begin, int end, int[][] coins) {
        if(begin == end - 1) {
            return 0;
        }
        if(coins[begin][end] != 0) {
            return coins[begin][end];
        }

        int maxnum = Integer.MIN_VALUE;
        for (int i = begin + 1; i < end; i++) {
            int result = 0;
            result = getMaxCoins(nums, begin, i, coins) +
                    getMaxCoins(nums, i, end, coins) +
                    nums[begin]*nums[end]*nums[i];
            maxnum = Math.max(maxnum, result);
        }
        coins[begin][end] = maxnum;
        System.out.println("coins: i :" + begin + ", j :" + end + " == " + maxnum);
        return maxnum;
    }


    @Test
    public void mytest() {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
