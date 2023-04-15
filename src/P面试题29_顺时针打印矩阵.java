public class P面试题29_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m*n];
        int sub = 0;
        int counter = 0;
        while (sub < (Math.min(m,n)+1)/2) {
            for (int i = sub; i <= n-1-sub; i++) {
                ans[counter++] = matrix[sub][i];
            }
            if(sub <= n - 1 - sub) {
                for (int i = sub+1; i <= m-1-sub; i++) {
                    ans[counter++] = matrix[i][n-1-sub];
                }
            }
            if(sub <= n - 1 - sub && sub + 1 <= m-1-sub) {
                for (int i = n-1-sub-1; i >= sub; i--) {
                    ans[counter++] = matrix[m-1-sub][i];
                }
            }
            if(sub <= n - 1 - sub && sub + 1 <= m-1-sub && n-1-sub-1 >= sub) {
                for (int i = m-1-sub-1; i > sub; i--) {
                    ans[counter++] = matrix[i][sub];
                }
            }
            sub++;
        }
        return ans;
    }
}
