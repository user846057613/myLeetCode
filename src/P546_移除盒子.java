public class P546_移除盒子 {
    public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return getPoint(boxes,dp,0,boxes.length-1,0);
    }

    private int getPoint(int[] boxes, int[][][] dp, int l, int r, int k) {
        if(l > r) return 0;
        if(dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        while (l < r && boxes[r] == boxes[r-1]) {
            r--;
            k++;
        }
        dp[l][r][k] = getPoint(boxes,dp,l,r-1,0) + (k+1)*(k+1);
        for (int i = l; i < r; i++) {
            if(boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k],
                        getPoint(boxes,dp,i+1,r-1,0)+
                        getPoint(boxes,dp,l,i,k+1));
            }
        }
        return dp[l][r][k];
    }
}
