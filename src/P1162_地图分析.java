import java.util.LinkedList;

public class P1162_地图分析 {
    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    int x , y;
    public int maxDistance(int[][] grid) {
        LinkedList<int[]> queue = new LinkedList<>();
        x = grid.length;
        if(x == 0) {
            return -1;
        }
        y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int dis = -1;
        int[][] gridDis = new int[x][y];
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int nowX = pos[0];
            int nowY = pos[1];
            for (int i = 0; i < 4; i++) {
                int dx = nowX + dxy[i][0];
                int dy = nowY + dxy[i][1];
                if(test(dx,dy) && gridDis[dx][dy] == 0 && grid[dx][dy] == 0) {
                    gridDis[dx][dy] = gridDis[nowX][nowY] + 1;
                    dis = Math.max(gridDis[dx][dy] , dis);
                    queue.offer(new int[]{dx,dy});
                }
            }
        }
        return dis;
    }

    private boolean test(int dx, int dy) {
        return dx >= 0 && dx <x && dy >= 0 && dy < y;
    }
}
