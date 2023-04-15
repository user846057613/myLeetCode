public class P200_岛屿数量 {
    boolean[][] visit;
    int[][] dxy = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int lengthX = grid.length;
        int lengthY = grid[0].length;
        visit = new boolean[lengthX][lengthY];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !visit[i][j]) {
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if(grid[x][y] == '1' && !visit[x][y]) {
            visit[x][y] = true;
            for (int i = 0; i < dxy.length; i++) {
                int dx = x + dxy[i][0];
                int dy = y + dxy[i][1];
                dfs(grid, dx, dy);
            }
        }
    }
}
