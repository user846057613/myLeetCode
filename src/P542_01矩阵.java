import java.util.Arrays;
import java.util.LinkedList;

public class P542_01矩阵 {

    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        LinkedList<MyPair> queue = new LinkedList<>();
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    visit[i][j] = true;
                    queue.offer(new MyPair(i,j));
                    ans[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            MyPair pair = queue.poll();
            for (int i = 0; i < dxy.length; i++) {
                int dx = pair.x + dxy[i][0];
                int dy = pair.y + dxy[i][1];
                if(isBound(dx,dy,m,n) && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    ans[dx][dy] = ans[pair.x][pair.y] + 1;
                    queue.offer(new MyPair(dx,dy));
                }
            }
        }
        return ans;
    }

    private boolean isBound(int dx, int dy, int m, int n) {
        return dx >= 0 && dx < m && dy >= 0 && dy < n;
    }

    class MyPair{
        int x,y;
        public MyPair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}


