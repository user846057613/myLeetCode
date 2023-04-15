import java.util.Arrays;

public class P221_最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix == null) {
            return 0;
        }
        int lengthX = matrix.length;
        int lengthY = matrix[0].length;
        int[][] dp = new int[lengthX][lengthY];
        int maxLength = 0;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < dp.length; i++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxLength = Math.max(maxLength, 1);
            }
        }
        for (int i = 0; i < lengthY; i++) {
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxLength = Math.max(maxLength, 1);
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(min, dp[i-1][j-1]) + 1;
                    maxLength = Math.max(dp[i][j], maxLength);
                }
            }
        }
        return maxLength * maxLength;
    }
}
