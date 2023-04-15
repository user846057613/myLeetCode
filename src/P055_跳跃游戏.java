import org.junit.Test;

public class P055_跳跃游戏 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if(dp[i]) {
                for (int j = 1; j <= nums[i] && i + j < length; j++) {
                    dp[i + j] = true;
                }
            }else {
                return false;
            }
        }
        return dp[length-1];
    }

    @Test
    public void test() {
        int[] num = {0,2,3};
        System.out.println(canJump(num));

    }
}
