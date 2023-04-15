public class 面试题0107_旋转矩阵 {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = n-1-i; j >= 0; j--) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = tmp;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = tmp;
        }
    }
}
