public class P695_岛屿的最大面积 {
    int x, y;
    int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] visit;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        x = grid.length;
        y = grid[0].length;
        visit = new boolean[x][y];
        int maxArea = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,dfs(grid,i,j,visit,1));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int xNow, int yNow, boolean[][] visit, int area) {
        visit[xNow][yNow] = true;
        for (int i = 0; i < 4; i++) {
            int dx = xNow + dxy[i][0];
            int dy = yNow + dxy[i][1];
            if(test(dx,dy) && grid[dx][dy] == 1 && !visit[dx][dy]) {
                area += dfs(grid,dx,dy,visit,1);
            }
        }
        return area;
    }

    private boolean test(int dx, int dy) {
        return dx >= 0 && dx < x && dy >= 0 && dy < y;
    }
}
