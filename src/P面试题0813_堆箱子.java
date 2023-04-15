import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class P面试题0813_堆箱子 {
    private int ans = 0;
    public int pileBox(int[][] box) {
        ans = 0;
//        solve(box, new ArrayList<Integer>(),0);
        Arrays.sort(box, (o1,o2) -> {
            if(o1[2] == o2[2] && o1[1] == o2[1]) return o1[0] - o2[0];
            else if(o1[2] == o2[2]) return o1[1] - o2[1];
            else return o1[2] - o2[2];
        });
        int n = box.length;
        int[] dp = new int[n];
        dp[0] = box[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if(box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private void solve(int[][] box, ArrayList<Integer> result, int height) {
        boolean flag = false;
        for (int i = 0; i < box.length; i++) {
            if(!result.contains(i)) {
                if(!result.isEmpty()) {
                    int index = result.get(result.size()-1);
                    if(box[i][0] < box[index][0] && box[i][1] < box[index][1] &&
                    box[i][2] < box[index][2]) {
                        flag = true;
                        ArrayList newResult = new ArrayList();
                        newResult.addAll(result);
                        newResult.add(i);
                        solve(box,newResult, height + box[i][2]);
                    }
                }else{
                    flag = true;
                    ArrayList newResult = new ArrayList();
                    newResult.add(i);
                    solve(box,newResult, height + box[i][2]);
                }
            }
        }
        if(!flag) {
            ans = Math.max(ans, height);
        }
    }

}
