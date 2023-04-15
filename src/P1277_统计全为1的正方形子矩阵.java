public class P1277_统计全为1的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int counter = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            counter += dp[i][0];
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            counter += dp[0][i];
        }
        if(dp[0][0] == 1) --counter;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1],
                            dp[i-1][j-1])) + 1;
                    counter += dp[i][j];
                }
            }
        }
        return counter;
    }



    public int countSquares1(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m,n);
        boolean[][][] dp = new boolean[m][n][len+1];
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][1] = matrix[i][j] == 1 ? true : false;
                if(dp[i][j][1]) ++counter;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k <= len; k++) {
                    dp[i][j][k] = matrix[i][j] == 1 &&
                            dp[i-1][j][k-1] && dp[i][j-1][k-1]&&
                            dp[i-1][j-1][k-1];
                    if(dp[i][j][k]) ++counter;
                }
            }
        }
        return counter;
    }
}
