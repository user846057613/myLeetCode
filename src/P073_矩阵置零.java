import java.util.HashSet;

public class P073_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (Integer integer : row) {
            for (int i = 0; i < matrix[integer].length; i++) {
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][integer] = 0;
            }
        }
        return;
    }
}
