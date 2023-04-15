import org.junit.Test;

import java.util.LinkedList;

public class P994_腐烂的橘子 {
    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return  -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + dxy[j][0];
                    int y = pos[1] + dxy[j][1];
                    if (isInBound(x, y, m, n) && !visit[x][y] && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        visit[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            time++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time > 0 ? --time : 0;
    }

    private boolean isInBound(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    @Test
    public void mytest(){
        int[][] a = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(a));
    }
}
