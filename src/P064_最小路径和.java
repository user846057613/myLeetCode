import org.junit.Test;

public class P064_最小路径和 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int lengthX = grid.length;
        int lengthY = grid[0].length;
        int[][] dp = new int[lengthX+1][lengthY+1];
//        for (int i = 1; i <= lengthX; i++) {
//            arrays
//        }
        for (int i = 1; i <= lengthX; i++) {
            for (int j = 1; j <= lengthY; j++) {
                if(i - 1 == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
                }else if( j - 1 == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i-1][j-1];
                }
            }
        }
        return dp[lengthX][lengthY];
    }

    @Test
    public void test() {
        int[][] num = {
                {1,3,1},{1,5,1},{4,2,1}
        };
        int x = minPathSum(num);
        System.out.println(x);
    }
}
