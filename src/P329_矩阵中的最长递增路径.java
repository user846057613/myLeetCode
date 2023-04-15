public class P329_矩阵中的最长递增路径 {
    int[][] num;
    int m;
    int n;
    boolean[][] visit;
    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] dp;
    int result;
    public int longestIncreasingPath(int[][] matrix) {
        this.num = matrix;
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        visit = new boolean[m][n];
        dp = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result = Math.max(result, dfs(i,j));
            }
        }
        return result;
    }

    private int dfs(int i, int j) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        visit[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dxy[k][0];
            int y = j + dxy[k][1];
            if(isValid(x,y) && num[x][y] > num[i][j] && !visit[x][y]) {
                dp[i][j] = Math.max(dp[i][j] , dfs(x,y));
            }
        }
        visit[i][j] = false;
        return ++dp[i][j];
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
