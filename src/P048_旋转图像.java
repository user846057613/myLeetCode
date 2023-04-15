import org.junit.Test;

import java.util.Arrays;

public class P048_旋转图像 {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        rotateUnit(matrix,0,matrix.length);

    }

    public void rotateUnit(int[][] matrix , int start, int n) {
        int[] num = new int[n];
        for (int i = start; i < n - start; i++) {
            num[i] = matrix[start][i];
        }
        for (int i = start; i < n - start; i++) {
            matrix[start][n-1-i] = matrix[i][start];
        }

        for (int i = start; i < n - start; i++) {
            matrix[i][start] = matrix[n-start - 1][i];
        }

        for (int i = n - start - 1, j = start; i >= start; i--, j++) {
             matrix[n-start-1][j] = matrix[i][n-start-1];
        }

        for (int i = start; i < n-start; i++) {
            matrix[i][n-start - 1] = num[i];
        }

        if(start <= (n-1) / 2) {
            rotateUnit(matrix, start+1, n);
        }
        return;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
