import org.junit.Test;

import java.util.Arrays;

public class P1024_视频拼接 {
    public int videoStitching(int[][] clips, int T) {
        boolean inBound = false;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < clips.length; i++) {
            if(clips[i][0] <= T && T <= clips[i][1]) {
                inBound = true;
            }
            maxNum = Math.max(maxNum,clips[i][1]);
            minNum = Math.min(minNum, clips[i][0]);
        }
        if(!inBound || minNum > 0) return -1;
        int[][] dp = new int[maxNum+1][maxNum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        for (int i = 0; i < clips.length; i++) {
            for (int j = clips[i][0]; j <= clips[i][1]; j++) {
                for (int k = j; k <= clips[i][1]; k++) {
                    dp[j][k] = 1;
                }
            }
        }

        for (int i = T; i >= 0; i--) {
            for (int j = i; j <= T; j++) {
                if(dp[i][j] == -1) {
                    int num = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        if(dp[i][k] != -1 && dp[k+1][j] != -1) {
                            num = Math.min(num, dp[i][k] + dp[k+1][j]);
                        }
                    }
                    if(num == Integer.MAX_VALUE) return -1;
                    dp[i][j] = num;
                }
            }
        }
        return dp[0][T];
    }

    @Test
    public void test() {
        int[][] a = {{0,2},{4,8}};
        System.out.println(videoStitching(a,5));
    }
}
