public class P240_搜索二维矩阵Ⅱ {
    int[][] dxy = {{1,0},{0,1}};
    boolean[][] visit;
    int m,n;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        m = matrix.length;
        n = matrix[0].length;
        visit = new boolean[m][n];
        return dfs(matrix,0,0,target);
    }

    private boolean dfs(int[][] matrix, int x, int y, int target) {
        visit[x][y] = true;
        if(matrix[x][y] == target) {
            return true;
        }else if(matrix[x][y] > target) {
            return false;
        }else {
            for (int i = 0; i < dxy.length; i++) {
                int dx = x + dxy[i][0];
                int dy = y + dxy[i][1];
                if(!outBound(dx,dy) && !visit[dx][dy] && dfs(matrix,dx,dy,target)) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean outBound(int dx, int dy) {
        return dx < 0 || dx >= m || dy < 0 || dy >= n;
    }
}
