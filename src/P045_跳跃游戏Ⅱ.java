import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P045_跳跃游戏Ⅱ {
    public int jump(int[] nums) {
        int ans = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i >= end) {
                end = maxPos;
                ans++;
            }
            if(end >= nums.length - 1) break;
        }
        return ans;
    }

    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[nums.length-1] = 0;
//        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
//            if(o1[0] == o2[0]) return o1[1]-o2[1];
//            else return o1[0] - o2[0];
//        });
        for (int i = nums.length-2; i >= 0; i--) {
            if(i + nums[i] <= nums.length - 1) {
                for (int j = 1; j <= nums[i]; j++) {
                    if(dp[i+j] == Integer.MAX_VALUE) continue;
                    else
                        dp[i] = Math.min(dp[i],dp[i+j] + 1);
                }

            }else{
                dp[i] = 1;
                continue;
            }
        }
        return dp[0];
    }
}
